package sweet.poato.enums.details;

/**
 * 业务通用异常枚举
 *
 */
public enum BusinessErrorCode {

    /**
     * 通用业务异常
     */
    BUSINESS_ERROR(800, "业务异常"),

    /**
     * 参数异常
     * */
    PARAMS_ERROR(999,"参数有误，请重新输入"),
    ;


    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    BusinessErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
