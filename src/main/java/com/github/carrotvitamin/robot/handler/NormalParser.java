package com.github.carrotvitamin.robot.handler;

import com.github.carrotvitamin.robot.factory.MoLiResParserFactory;
import com.github.carrotvitamin.robot.model.RobotResTypeEnum;
import org.springframework.stereotype.Component;

/**
 * @author yinshaobo on 2019-08-23 10:51
 */
@Component("normal")
public class NormalParser extends AbstractMoLiResParseHandler {

    @Override
    public String parse(String response) {
        return response;
    }

    @Override
    public void init() {
        MoLiResParserFactory.PARSE_HANDLER_MAP.put(RobotResTypeEnum.普通文本, this);
    }
}
