package com.github.carrotvitamin.robot.model;

import com.github.carrotvitamin.robot.model.exception.RobotCheckException;
import com.github.carrotvitamin.robot.model.exception.RobotRuntimeException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @ClassName: Response
 * @Description:
 * @author: yinshaobo
 * @date: 2019/3/13 2:32 PM
 */
@Setter
@Getter
@ToString
public class Response {

    private Response() {}

    private Response(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private Response(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private String code;

    private String message;

    private Object data;

    public static Response success() {
        return new Response(ResCodeEnum.SUCCESS.getCode(), ResCodeEnum.SUCCESS.getMessage());
    }

    public static Response success(Object data) {
        return new Response(ResCodeEnum.SUCCESS.getCode(), ResCodeEnum.SUCCESS.getMessage(), data);
    }

    public static Response fail(ResCodeEnum resCodeEnum) {
        return new Response(resCodeEnum.getCode(), resCodeEnum.getMessage());
    }

    public static Response fail(ResCodeEnum resCodeEnum, Object data) {
        return new Response(resCodeEnum.getCode(), resCodeEnum.getMessage(), data);
    }

    public static Response fail() {
        return new Response(ResCodeEnum.FAILURE.getCode(), ResCodeEnum.FAILURE.getMessage());
    }

    public static Response fail(String code, String message) {
        return new Response(code, message);
    }

    public static Response operate(boolean value) {
        if (value) {
            return success(null);
        } else {
            return fail();
        }
    }

    public static Response buildErrorResponse(Exception exception) {
        if (exception instanceof RobotCheckException) {
            RobotCheckException e = (RobotCheckException) exception;
            return fail(e.getCode(), e.getMessage());
        } else if (exception instanceof RobotRuntimeException) {
            RobotRuntimeException e = (RobotRuntimeException) exception;
            return fail(e.getCode(), e.getMessage());
        } else {
            return fail();
        }
    }
}
