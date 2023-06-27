package sweet.poato.res.oauth;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: TheSunshine
 * @Date: 2022/12/22 19:08
 * @Version 1.0
 */
@Data
@Builder
public class PassportTokenVO {


    /**
     * 访问令牌
     */
    private String accessToken;

    /**
     * 刷新令牌
     */
    private String refreshToken;

    /**
     * 访问令牌头前缀
     */
    private String tokenHead;

    /**
     * 有效时间（秒）
     */
    private int expiresIn;
}
