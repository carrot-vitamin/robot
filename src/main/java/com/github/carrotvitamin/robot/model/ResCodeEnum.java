package com.github.carrotvitamin.robot.model;

/**
 * @ClassName: ResCodeEnum
 * @Description:
 * @author: yinshaobo
 * @date: 2019/3/13 2:33 PM
 */
public enum ResCodeEnum {

    SUCCESS("000000", "请求成功"),

    FAILURE("999999", "请求失败"),

    QUESTION_IS_EMPTY("000901", "问题不能为空"),
    INVOKE_MOLI_QA_FAILURE("000902", "请求茉莉机器人问答失败"),
    ;

    private String code;

    private String message;

    ResCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
