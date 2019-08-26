package com.github.carrotvitamin.robot.handler.moli;

import com.alibaba.fastjson.JSONObject;
import com.github.carrotvitamin.robot.factory.MoLiResParserFactory;
import com.github.carrotvitamin.robot.model.moli.RobotResTypeEnum;
import org.springframework.stereotype.Component;

/**
 * @author yinshaobo on 2019-08-22 17:40
 * 笑话解析
 */
@Component("joke")
public class JokeParser extends AbstractMoLiResParseHandler {

    @Override
    public String parse(String response) {
        JSONObject jsonObject = JSONObject.parseObject(response);
        StringBuilder builder = new StringBuilder();
        builder.append("《").append(jsonObject.getString("title")).append("》\n");
        builder.append(jsonObject.getString("content"));
        return builder.toString();
    }

    @Override
    public void init() {
        MoLiResParserFactory.PARSE_HANDLER_MAP.put(RobotResTypeEnum.笑话, this);
    }
}
