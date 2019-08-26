package com.github.carrotvitamin.robot.service.moli;

import com.github.carrotvitamin.robot.model.moli.RobotResponse;
import com.github.carrotvitamin.robot.model.exception.RobotCheckException;

/**
 * @author yinshaobo on 2019-08-22 16:05
 */
public interface IMoLiService {

    RobotResponse qa(String question) throws RobotCheckException;
}
