package com.github.carrotvitamin.robot.model.moli;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yinshaobo on 2019-08-23 11:38
 */
@Setter
@Getter
@ToString
public class QARequest {

    private String requestId;

    private String question;
}
