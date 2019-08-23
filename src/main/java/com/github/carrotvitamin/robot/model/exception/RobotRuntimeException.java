package com.github.carrotvitamin.robot.model.exception;

import com.github.carrotvitamin.robot.model.ResCodeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @author
 * @desc RobotRuntimeException
 * @date 2019/3/17 11:29
 */
@Setter
@Getter
public class RobotRuntimeException extends RuntimeException {

    private String code;

    private String message;

    public RobotRuntimeException() {
        this.code = ResCodeEnum.FAILURE.getCode();
        this.message = ResCodeEnum.FAILURE.getMessage();
    }

    public RobotRuntimeException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public RobotRuntimeException(ResCodeEnum resCodeEnum) {
        this.code = resCodeEnum.getCode();
        this.message = resCodeEnum.getMessage();
    }

    @Override
    public String toString() {
        return "RobotRuntimeException{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
