package com.github.carrotvitamin.robot.service.tencent.impl;

import com.github.carrotvitamin.robot.model.ResCodeEnum;
import com.github.carrotvitamin.robot.model.exception.RobotCheckException;
import com.github.carrotvitamin.robot.model.moli.RobotResponse;
import com.github.carrotvitamin.robot.model.tencent.QARequest;
import com.github.carrotvitamin.robot.model.tencent.QAResponse;
import com.github.carrotvitamin.robot.sao.tencent.IQaSAO;
import com.github.carrotvitamin.robot.service.tencent.IQAService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yinshaobo on 2019-08-26 16:18
 */
@Slf4j
@Service
public class QAServiceImpl implements IQAService {

    @Autowired
    private IQaSAO qaSAO;

    @Override
    public RobotResponse qa(com.github.carrotvitamin.robot.model.moli.QARequest qaRequest) throws RobotCheckException {
        try {
            QAResponse qa = this.qaSAO.qa(new QARequest(qaRequest.getRequestId(), qaRequest.getQuestion()));
            if (0 == qa.getRet()) {
                return new RobotResponse(qa.getData().getAnswer());
            }
             throw new RobotCheckException(qa.getRet().toString(), qa.getMsg());
        } catch (Exception e) {
            log.error("调用企业闲聊sao异常！req={}", qaRequest, e);
            throw new RobotCheckException(ResCodeEnum.INVOKE_TENCENT_QA_FAILURE);
        }
    }
}
