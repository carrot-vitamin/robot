package com.github.carrotvitamin.robot.service.moli.impl;

import com.github.carrotvitamin.robot.factory.MoLiResParserFactory;
import com.github.carrotvitamin.robot.handler.moli.AbstractMoLiResParseHandler;
import com.github.carrotvitamin.robot.model.ResCodeEnum;
import com.github.carrotvitamin.robot.model.moli.RobotRequest;
import com.github.carrotvitamin.robot.model.moli.RobotResponse;
import com.github.carrotvitamin.robot.model.exception.RobotCheckException;
import com.github.carrotvitamin.robot.sao.moli.IMoLiSAO;
import com.github.carrotvitamin.robot.service.moli.IMoLiService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author yinshaobo on 2019-08-22 16:08
 */
@Slf4j
@Service
public class MoLiServiceImpl implements IMoLiService {

    @Value("${moli.api.key}")
    private String apiKey;

    @Value("${moli.api.secret}")
    private String apiSecret;

    @Autowired
    private IMoLiSAO moLiSAO;

    @Override
    public RobotResponse qa(String question) throws RobotCheckException {
        if (StringUtils.isBlank(question)) {
            log.warn("no question!");
            throw new RobotCheckException(ResCodeEnum.QUESTION_IS_EMPTY);
        }
        RobotRequest request = new RobotRequest();
        request.setQuestion(question);
        request.setApiKey(this.apiKey);
        request.setApiSecret(this.apiSecret);
        request.setLimit(6);
        String response;
        try {
            response = this.moLiSAO.qa(request);
        } catch (Exception e) {
            log.error("invoke moli sao error, req={}", request, e);
            throw new RobotCheckException(ResCodeEnum.INVOKE_MOLI_QA_FAILURE);
        }
        AbstractMoLiResParseHandler parseHandler = MoLiResParserFactory.getHandler(request.getQuestion());
        String result = parseHandler.parse(response);
        return new RobotResponse(result);
    }
}
