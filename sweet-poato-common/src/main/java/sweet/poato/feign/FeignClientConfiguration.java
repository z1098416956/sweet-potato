package sweet.poato.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;


/**
 * feign client配置
 */
@Slf4j
@Configuration
public class FeignClientConfiguration /*implements RequestInterceptor*/ {

/*    @Override
    public void apply(RequestTemplate requestTemplate) {
        log.info("sssss :{}","sss");
    }*/
}
