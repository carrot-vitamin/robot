package com.github.carrotvitamin.robot.model.moli;

import lombok.Data;

/**
 * @author yinshaobo on 2019-08-22 16:05
 */
@Data
public class RobotResponse {

    private String data;

    public RobotResponse(String data) {
        this.data = data;
    }
}
