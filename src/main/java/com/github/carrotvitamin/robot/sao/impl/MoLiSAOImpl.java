package com.github.carrotvitamin.robot.sao.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.carrotvitamin.robot.model.RobotRequest;
import com.github.carrotvitamin.robot.sao.IMoLiSAO;
import com.project.base.util.EncodeUtils;
import com.project.base.util.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author yinshaobo on 2019-08-22 15:06
 */
@Slf4j
@Service
public class MoLiSAOImpl implements IMoLiSAO {

    @Value("${qa.url}")
    private String qaUrl;

    @Override
    public String qa(RobotRequest robotRequest) throws Exception {
        log.info("invoke moli robot sao, url={}, request={}", this.qaUrl, robotRequest);
        Map<String, Object> requestMap = JSON.parseObject(JSON.toJSONString(robotRequest), new TypeReference<Map<String, Object>>(){});
        String res = HttpUtils.get(this.qaUrl, requestMap);
        String utf8Res = EncodeUtils.unicodeToString(res);
        log.info("invoke moli robot sao, url={}\nrequest={}\nres={}\nutf-8 res={}", this.qaUrl, requestMap, res, utf8Res);
        return utf8Res;
    }

}
