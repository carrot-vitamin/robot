package com.github.carrotvitamin.robot.sao.tencent.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.github.carrotvitamin.robot.model.tencent.QARequest;
import com.github.carrotvitamin.robot.model.tencent.QAResponse;
import com.github.carrotvitamin.robot.sao.tencent.IQaSAO;
import com.github.carrotvitamin.robot.util.SignUtils;
import com.project.base.util.HttpUtils;
import com.project.base.util.KeyGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author yinshaobo on 2019-08-26 10:35
 */
@Slf4j
@Service
public class QaSAOImpl implements IQaSAO {

    @Value("${tencent.qa.url}")
    private String url;

    @Value("${tencent.appId}")
    private String appId;

    @Value("${tencent.appKey}")
    private String appKey;

    @Override
    public QAResponse qa(QARequest qaRequest) throws Exception {
        log.info("请求调用腾讯智能闲聊API，url={}, req={}", this.url, qaRequest);
        if (StringUtils.isBlank(qaRequest.getSession())) {
            qaRequest.setSession(KeyGenerator.generate());
        }
        Map<String, Object> params = JSON.parseObject(JSON.toJSONString(qaRequest), new TypeReference<Map<String, Object>>(){});
        params.put("app_id", this.appId);
        params.put("time_stamp", System.currentTimeMillis() / 1000);
        params.put("nonce_str", KeyGenerator.generate());
        String sign = SignUtils.sign(params, this.appKey);
        params.put("sign", sign);
        String resJson = HttpUtils.post(this.url, params);
        log.info("请求调用腾讯智能闲聊API结束，url={}, req={}, res={}", this.url, qaRequest, resJson);
        return JSONObject.parseObject(resJson, QAResponse.class);
    }
}
