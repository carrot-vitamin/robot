package com.github.carrotvitamin.robot.model.tencent;

import lombok.Data;

/**
 * @author yinshaobo on 2019-08-26 16:08
 */
@Data
public class QAResData {

    /**
     * 是	string	UTF-8编码，非空且长度上限32字节
     */
    private String session;

    /**
     * 是	string	UTF-8编码，非空
     */
    private String answer;
}
