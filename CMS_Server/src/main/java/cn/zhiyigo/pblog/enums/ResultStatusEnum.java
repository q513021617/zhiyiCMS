package cn.zhiyigo.pblog.enums;

public enum ResultStatusEnum {

    UNKOWN_ERROR(-1, "未知错误"),

    SUCCESS(200, "请求成功"),

    INTERNAL_ERROR(500, "服务器内部错误"),

    BAD_REQUEST(400, "请求参数有误"),

    ACCESS_DENIED(403, "没有权限"),

    UNKOWN_REASON(404, "资源不存在"),

    ;

    private Integer status;

    private String msg;

    ResultStatusEnum(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

}
