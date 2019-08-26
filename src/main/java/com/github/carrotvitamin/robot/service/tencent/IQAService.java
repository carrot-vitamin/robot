package com.github.carrotvitamin.robot.service.tencent;

import com.github.carrotvitamin.robot.model.exception.RobotCheckException;
import com.github.carrotvitamin.robot.model.moli.QARequest;
import com.github.carrotvitamin.robot.model.moli.RobotResponse;

/**
 * @author yinshaobo on 2019-08-26 16:17
 */
public interface IQAService {

    RobotResponse qa(QARequest qaRequest) throws RobotCheckException;
}
