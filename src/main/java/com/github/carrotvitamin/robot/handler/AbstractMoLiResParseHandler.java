package com.github.carrotvitamin.robot.handler;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author yinshaobo on 2019-08-22 17:39
 * 茉莉机器人响应数据解析器
 */
public abstract class AbstractMoLiResParseHandler implements InitializingBean {

    public abstract String parse(String response);
}
