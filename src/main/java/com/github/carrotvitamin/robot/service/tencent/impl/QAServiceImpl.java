package com.github.carrotvitamin.robot.service.tencent.impl;

import com.github.carrotvitamin.robot.model.ResCodeEnum;
import com.github.carrotvitamin.robot.model.exception.RobotCheckException;
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
    public String qa(String question, String user) throws RobotCheckException {
        try {
            QAResponse qa = this.qaSAO.qa(new QARequest(user, question));
            if (0 == qa.getRet()) {
                return qa.getData().getAnswer();
            }
             throw new RobotCheckException(qa.getRet().toString(), qa.getMsg());
        } catch (Exception e) {
            log.error("调用企业闲聊sao异常！question={}, user={}", question, user, e);
            throw new RobotCheckException(ResCodeEnum.INVOKE_TENCENT_QA_FAILURE);
        }
    }
}
