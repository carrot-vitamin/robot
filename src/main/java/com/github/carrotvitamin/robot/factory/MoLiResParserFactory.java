package com.github.carrotvitamin.robot.factory;

import com.github.carrotvitamin.robot.handler.moli.AbstractMoLiResParseHandler;
import com.github.carrotvitamin.robot.model.moli.RobotResTypeEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yinshaobo on 2019-08-23 10:14
 */
@Slf4j
public class MoLiResParserFactory {

    public static final Map<RobotResTypeEnum, AbstractMoLiResParseHandler> PARSE_HANDLER_MAP = new HashMap<>(16);

    public static AbstractMoLiResParseHandler getHandler(String question) {
        RobotResTypeEnum resEnum;
        try {
            resEnum = RobotResTypeEnum.valueOf(question);
        } catch (IllegalArgumentException e) {
            log.warn("请求茉莉响应类型转换异常, question={}", question);
            resEnum = RobotResTypeEnum.普通文本;
        }
        return PARSE_HANDLER_MAP.get(resEnum);
    }
}
