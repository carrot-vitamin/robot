package com.github.carrotvitamin.robot.model.moli;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author yinshaobo on 2019-08-22 14:55
 */
@Data
public class RobotRequest {

    /**
     * 对API的提问字符
     * 必传
     */
    private String question;

    /**
     * API最大分析次数，取值范围为2-8，默认值为5，值越大精确率越高，但是会影响API响应时间
     * 非必传
     */
    private Integer limit;

    @JSONField(name = "api_key")
    private String apiKey;

    @JSONField(name = "api_secret")
    private String apiSecret;

    /**
     * 定义返回结果类型（普通文本/xml/json），暂未实现，默认普通文本
     * 非必传
     */
    private String type;
}
