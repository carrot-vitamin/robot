package com.github.carrotvitamin.robot.model.exception;

import com.github.carrotvitamin.robot.model.ResCodeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @author
 * @desc RobotCheckException
 * @date 2019/3/17 11:29
 */
@Setter
@Getter
public class RobotCheckException extends Exception {

    private String code;

    private String message;

    public RobotCheckException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public RobotCheckException(ResCodeEnum resCodeEnum) {
        this.code = resCodeEnum.getCode();
        this.message = resCodeEnum.getMessage();
    }

    @Override
    public String toString() {
        return "RobotCheckException{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
