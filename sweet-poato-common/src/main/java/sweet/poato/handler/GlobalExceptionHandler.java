package sweet.poato.handler;

import com.netflix.client.ClientException;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import sweet.poato.annotation.IgnoreResponseAdvice;
import sweet.poato.enums.CommonErrorCode;
import sweet.poato.exception.category.BusinessException;
import sweet.poato.result.Result;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @Author: TheSunshine
 * @Date: 2022/8/12 15:17
 * @Version 1.0
 * 异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * FeignException 类捕获
     */
    @ExceptionHandler(value = FeignException.class)
    public Result handlerFeignException(FeignException e) throws Throwable {
     //   errorDispose(e);
        outPutError(FeignException.class, CommonErrorCode.SERVER_ERROR, e);
        return Result.error(CommonErrorCode.SERVER_ERROR);
    }


    /**
     * ClientException 类捕获
     */
    @ExceptionHandler(value = ClientException.class)
    public Result handlerClientException(ClientException e) throws Throwable {
      //  errorDispose(e);
        outPutError(ClientException.class, CommonErrorCode.RPC_ERROR, e);
        return Result.error(CommonErrorCode.RPC_ERROR);
    }

    /**
     * 手动抛出异常
     * @param e
     * @return
     * @throws Throwable
     */
    @ExceptionHandler(value = BusinessException.class)
    public Result handlerBusinessException(BusinessException e) throws Throwable{
        outPutError(BusinessException.class, CommonErrorCode.BUSINESS_ERROR, e);
        return Result.error(e.getCode(),e.getMessage());
    }


    /**
     * Exception 类捕获 500 异常处理
     */
    @ExceptionHandler(value = Exception.class)
    public Result handlerException(Exception e) throws Throwable {
       // errorDispose(e);
        return ifDepthExceptionType(e);
    }


    /**
     * NoHandlerFoundException 404 异常处理
     */
/*
    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result handlerNoHandlerFoundException(NoHandlerFoundException e) throws Throwable {
        errorDispose(e);
        outPutErrorWarn(NoHandlerFoundException.class, CommonErrorCode.NOT_FOUND, e);
        return Result.error(CommonErrorCode.NOT_FOUND);
    }
*/

    /**
     * HttpRequestMethodNotSupportedException 405 异常处理
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result handlerHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException e) throws Throwable {
     //   errorDispose(e);
        outPutErrorWarn(HttpRequestMethodNotSupportedException.class,
                CommonErrorCode.METHOD_NOT_ALLOWED, e);
        return Result.error(CommonErrorCode.METHOD_NOT_ALLOWED);
    }


    /**
     * 二次深度检查错误类型
     */
    private Result ifDepthExceptionType(Throwable throwable) throws Throwable {
        Throwable cause = throwable.getCause();
        if (cause instanceof ClientException) {
            return handlerClientException((ClientException) cause);
        }
        if (cause instanceof FeignException) {
            return handlerFeignException((FeignException) cause);
        }
        if(cause instanceof BusinessException){
            return handlerBusinessException((BusinessException) cause);
        }

        outPutError(Exception.class, CommonErrorCode.EXCEPTION, throwable);
        return Result.error(CommonErrorCode.EXCEPTION);
    }

    /**
     * 校验是否进行异常处理
     *
     * @param e   异常
     * @param <T> extends Throwable
     * @throws Throwable 异常
     */
    private <T extends Throwable> void errorDispose(T e) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HandlerMethod handlerMethod = (HandlerMethod) request.getAttribute("org.springframework.web.servlet.HandlerMapping.bestMatchingHandler");

        // 获取异常 Controller
        Class<?> beanType = handlerMethod.getBeanType();
        // 获取异常方法
        Method method = handlerMethod.getMethod();

        // 判断方法是否存在 IgnoreResponseAdvice 注解
        IgnoreResponseAdvice methodAnnotation = method.getAnnotation(IgnoreResponseAdvice.class);
        if (methodAnnotation != null) {
            // 是否使用异常处理
            if (!methodAnnotation.errorDispose()) {
                throw e;
            } else {
                return;
            }
        }
        // 判类是否存在 IgnoreResponseAdvice 注解
        IgnoreResponseAdvice classAnnotation = beanType.getAnnotation(IgnoreResponseAdvice.class);
        if (classAnnotation != null) {
            if (!classAnnotation.errorDispose()) {
                throw e;
            }
        }
    }


    public void outPutError(Class errorType, Enum secondaryErrorType, Throwable throwable) {
        log.error("[{}] {}: {}", errorType.getSimpleName(), secondaryErrorType, throwable.getMessage(),
                throwable);
    }

    public void outPutErrorWarn(Class errorType, Enum secondaryErrorType, Throwable throwable) {
        log.warn("[{}] {}: {}", errorType.getSimpleName(), secondaryErrorType, throwable.getMessage());
    }

}
