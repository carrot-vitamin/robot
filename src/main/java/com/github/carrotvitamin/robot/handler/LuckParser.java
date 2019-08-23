package com.github.carrotvitamin.robot.handler;

import com.alibaba.fastjson.JSONObject;
import com.github.carrotvitamin.robot.factory.MoLiResParserFactory;
import com.github.carrotvitamin.robot.model.RobotResTypeEnum;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author yinshaobo on 2019-08-23 11:25
 * 签运解析
 */
@Component("json")
public class LuckParser extends AbstractMoLiResParseHandler {

    @Override
    public String parse(String response) {
        JSONObject jsonObject = JSONObject.parseObject(response);
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            builder.append(entry.getKey()).append(" ：").append(entry.getValue()).append("\n");
        }
        return builder.toString();
    }

    @Override
    public void init() {
        MoLiResParserFactory.PARSE_HANDLER_MAP.put(RobotResTypeEnum.月老灵签, this);
        MoLiResParserFactory.PARSE_HANDLER_MAP.put(RobotResTypeEnum.观音灵签, this);
        MoLiResParserFactory.PARSE_HANDLER_MAP.put(RobotResTypeEnum.财神爷灵签, this);
    }
}
