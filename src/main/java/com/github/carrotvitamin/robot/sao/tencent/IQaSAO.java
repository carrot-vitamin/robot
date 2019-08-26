package com.github.carrotvitamin.robot.sao.tencent;

import com.github.carrotvitamin.robot.model.tencent.QARequest;
import com.github.carrotvitamin.robot.model.tencent.QAResponse;

/**
 * @author yinshaobo on 2019-08-26 10:34
 */
public interface IQaSAO {

    QAResponse qa(QARequest qaRequest) throws Exception;
}
