package com.github.carrotvitamin.robot.handler;

import javax.annotation.PostConstruct;

/**
 * @author yinshaobo on 2019-08-22 17:39
 * 茉莉机器人响应数据解析器
 */
public abstract class AbstractMoLiResParseHandler {

    public abstract String parse(String response);

    @PostConstruct
    public abstract void init();
}
