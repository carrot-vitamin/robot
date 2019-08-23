package com.github.carrotvitamin.robot;

import com.github.carrotvitamin.robot.model.RobotResTypeEnum;

/**
 * @author yinshaobo on 2019-08-22 15:29
 */
public class MainTest {

    public static void main(String[] args) {
        RobotResTypeEnum resEnum = RobotResTypeEnum.valueOf("笑话aaa");
        System.out.println(resEnum);
    }
}
