package com.github.carrotvitamin.robot.service.tencent;

import com.github.carrotvitamin.robot.model.exception.RobotCheckException;

/**
 * @author yinshaobo on 2019-08-26 16:17
 */
public interface IQAService {

    String qa(String question, String user) throws RobotCheckException;
}
