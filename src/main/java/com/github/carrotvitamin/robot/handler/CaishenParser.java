package com.github.carrotvitamin.robot.handler;

import com.alibaba.fastjson.JSONObject;
import com.github.carrotvitamin.robot.factory.MoLiResParserFactory;
import com.github.carrotvitamin.robot.model.RobotResTypeEnum;
import org.springframework.stereotype.Component;

/**
 * @author yinshaobo on 2019-08-22 17:42
 * 财神灵签解析
 */
@Component("caishen")
public class CaishenParser extends AbstractMoLiResParseHandler {

    @Override
    public String parse(String response) {
        JSONObject jsonObject = JSONObject.parseObject(response);
        StringBuilder builder = new StringBuilder();
        builder.append("签号:").append(jsonObject.getString("number1")).append("\n");
        builder.append("签号:").append(jsonObject.getString("number2")).append("\n");
        builder.append("签语:").append(jsonObject.getString("qianyu")).append("\n");
        builder.append("注释:").append(jsonObject.getString("zhushi")).append("\n");
        builder.append("解签:").append(jsonObject.getString("jieqian")).append("\n");
        builder.append("解说:").append(jsonObject.getString("jieshuo")).append("\n");
        builder.append("结果:").append(jsonObject.getString("jieguo")).append("\n");
        builder.append("婚姻:").append(jsonObject.getString("hunyin")).append("\n");
        builder.append("交易:").append(jsonObject.getString("jiaoyi")).append("\n");
        builder.append("灵签类型:").append(jsonObject.getString("type")).append("\n");
        return builder.toString();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        MoLiResParserFactory.PARSE_HANDLER_MAP.put(RobotResTypeEnum.财神爷灵签, this);
    }
}
