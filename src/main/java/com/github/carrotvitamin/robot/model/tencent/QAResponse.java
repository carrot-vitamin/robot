package com.github.carrotvitamin.robot.model.tencent;

import lombok.Data;

/**
 * @author yinshaobo on 2019-08-26 09:59
 */
@Data
public class QAResponse {

    /**
     * 是	int	返回码； 0表示成功，非0表示出错
     */
    private Integer ret;

    /**
     * 是	string	返回信息；ret非0时表示出错时错误原因
     */
    private String msg;

    /**
     * 是	object	返回数据；ret为0时有意义
     */
    private QAResData data;
}
