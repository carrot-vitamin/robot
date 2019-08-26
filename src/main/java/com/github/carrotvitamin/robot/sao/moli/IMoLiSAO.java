package com.github.carrotvitamin.robot.sao.moli;

import com.github.carrotvitamin.robot.model.moli.RobotRequest;

/**
 * @author yinshaobo on 2019-08-22 09:39
 * 茉莉机器人sao url：http://www.itpk.cn/profile.php
 */
public interface IMoLiSAO {

    /**
     * 调用茉莉机器人问答，仅文本
     * @param robotRequest
     * @return
     */
    String qa(RobotRequest robotRequest) throws Exception;
}
