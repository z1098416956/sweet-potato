package sweet.poato.enums.details;


import sweet.poato.enums.ErrorCode;

/**
 * @Author: TheSunshine
 * @Date: 2022/8/12 16:14
 * @Version 1.0
 */
public interface SystemErrorCode {

    // ============ 通用异常 ===================
    ErrorCode CREATE_ERROR = new ErrorCode(100100, "添加失败");
    ErrorCode UPDATE_ERROR = new ErrorCode(100200, "编辑失败");
    ErrorCode SELECT_ERROR = new ErrorCode(100300, "查询失败");
    ErrorCode DELETE_ERROR = new ErrorCode(100400, "删除失败");
    ErrorCode EXPORT_ERROR = new ErrorCode(100500, "导出失败");
}
