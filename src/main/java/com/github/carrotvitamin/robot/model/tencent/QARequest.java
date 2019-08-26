package com.github.carrotvitamin.robot.model.tencent;

import lombok.Data;

/**
 * @author yinshaobo on 2019-08-26 09:55
 */
@Data
public class QARequest {

    /**
     * 是	string	UTF-8编码，非空且长度上限32字节	10000	会话标识（应用内唯一）
     */
    private String session;

    /**
     * 是	string	UTF-8编码，非空且长度上限300字节	你叫啥	用户输入的聊天内容
     */
    private String question;

    public QARequest(String question) {
        this.question = question;
    }

    public QARequest(String session, String question) {
        this.session = session;
        this.question = question;
    }
}
