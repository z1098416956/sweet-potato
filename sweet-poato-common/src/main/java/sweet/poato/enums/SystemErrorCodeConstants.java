package sweet.poato.enums;

/**
 * @Author: TheSunshine
 * @Date: 2022/12/19 17:15
 * @Version 1.0
 */
public interface SystemErrorCodeConstants {

    //1000基础模块
    ErrorCode CREATE_ERROR = new ErrorCode(10001001, "认证失败");


    //2000系统模块
    ErrorCode USER_NOT_EXIST = new ErrorCode(10002001, "用户不存在");

}
