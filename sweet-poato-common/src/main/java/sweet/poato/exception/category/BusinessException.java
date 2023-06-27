package sweet.poato.exception.category;

import sweet.poato.enums.CommonErrorCode;
import sweet.poato.enums.details.BusinessErrorCode;

/**
 * @Author: TheSunshine
 * @Date: 2022/8/12 16:08
 * @Version 1.0
 */
public class BusinessException extends RuntimeException{

    private Integer code;
    private boolean isShowMsg = true;

    public Integer getCode() {
        return code;
    }

    public boolean isShowMsg() {
        return isShowMsg;
    }

    /**
     * 使用枚举传参
     *
     * @param errorCode 异常枚举
     */
    public BusinessException(BusinessErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    /**
     * 使用CommonErrorCode枚举传参
     *
     * @param errorCode 异常枚举
     */
    public BusinessException(CommonErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    /**
     * 使用自定义消息
     *
     * @param code 值
     * @param msg  详情
     */
    public BusinessException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
}
