package sweet.poato.res.system;

import lombok.Data;

/**
 * @Author: TheSunshine
 * @Date: 2022/12/22 18:35
 * @Version 1.0
 */
@Data
public class UserInfoVO {
    /**
     * 主键Id
     */
    private Long id;
    /**
     * 用户名称
     */
    private String username;
    /**
     * 用户头像
     */
    private String avatar;
    /**
     * 用户真实头像
     */
    private String name;
    /**
     * 性别 0女1男2保密
     */
    private Integer sex;
    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户类型1 普通用户 2系统用户
     */
    private Integer sysType;
}
