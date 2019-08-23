package com.github.carrotvitamin.robot.handler;

import com.alibaba.fastjson.JSONObject;
import com.github.carrotvitamin.robot.factory.MoLiResParserFactory;
import com.github.carrotvitamin.robot.model.RobotResTypeEnum;
import org.springframework.stereotype.Component;

/**
 * @author yinshaobo on 2019-08-22 17:42
 * 观音灵签解析
 */
@Component("guanyin")
public class GuanyinParser extends AbstractMoLiResParseHandler {

    @Override
    public String parse(String response) {
        JSONObject jsonObject = JSONObject.parseObject(response);
        StringBuilder builder = new StringBuilder();
        builder.append("签号:").append(jsonObject.getString("number1")).append("\n");
        builder.append("签号:").append(jsonObject.getString("number2")).append("\n");
        builder.append("签的好坏:").append(jsonObject.getString("haohua")).append("\n");
        builder.append("签语:").append(jsonObject.getString("qianyu")).append("\n");
        builder.append("诗意解签:").append(jsonObject.getString("shiyi")).append("\n");
        builder.append("白话解签:").append(jsonObject.getString("jieqian")).append("\n");
        builder.append("灵签类型:").append(jsonObject.getString("type")).append("\n");
        return builder.toString();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        MoLiResParserFactory.PARSE_HANDLER_MAP.put(RobotResTypeEnum.观音灵签, this);
    }
}
