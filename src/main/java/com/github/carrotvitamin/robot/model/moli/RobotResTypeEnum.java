package com.github.carrotvitamin.robot.model.moli;

/**
 * @author yinshaobo on 2019-08-22 16:54
 * 茉莉机器人返回json格式的几个问题
 */
public enum RobotResTypeEnum {

    普通文本,
    笑话,
    观音灵签,
    月老灵签,
    财神爷灵签,
    ;

    /**
     * 判断是否是响应json的请求
     * @param question 请求问题
     * @return 是否响应json格式
     */
    public static boolean isJsonReq(String question) {
        boolean isJson = false;
        for (RobotResTypeEnum v : RobotResTypeEnum.values()) {
            if (v != 普通文本 && v.toString().equals(question)) {
                isJson = true;
                break;
            }
        }
        return isJson;
    }

}
