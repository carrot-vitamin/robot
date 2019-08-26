package com.github.carrotvitamin.robot.util;

import com.project.base.util.MD5Utils;
import lombok.extern.slf4j.Slf4j;

import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author yinshaobo on 2019-08-26 10:07
 * tencent请求签名工具类
 */
@Slf4j
public class SignUtils {

    private SignUtils() {
    }

    /*
将<key, value>请求参数对按key进行字典升序排序，得到有序的参数对列表N
将列表N中的参数对按URL键值对的格式拼接成字符串，得到字符串T（如：key1=value1&key2=value2），URL键值拼接过程value部分需要URL编码，URL编码算法用大写字母，例如%E8，而不是小写%e8
将应用密钥以app_key为键名，组成URL键值拼接到字符串T末尾，得到字符串S（如：key1=value1&key2=value2&app_key=密钥)
对字符串S进行MD5运算，将得到的MD5值所有字符转换成大写，得到接口请求签名
     */

    public static String sign(Map<String, Object> params, String appKey) throws Exception {
        Map<String, Object> sortedParams = new TreeMap<>(params);
        Set<Map.Entry<String, Object>> entries = sortedParams.entrySet();
        StringBuilder baseString = new StringBuilder();
        for (Map.Entry<String, Object> param : entries) {
            if (param.getValue() != null && !"".equals(param.getKey().trim()) &&
                    !"sign".equals(param.getKey().trim()) && !"".equals(param.getValue())) {
                baseString.append(param.getKey().trim()).append("=")
                        .append(URLEncoder.encode(param.getValue().toString(), "UTF-8")).append("&");
            }
        }
        if (baseString.length() > 0) {
            baseString.deleteCharAt(baseString.length() - 1).append("&app_key=").append(appKey);
        }
        String sign = MD5Utils.getMD5String(baseString.toString());
        return sign.toUpperCase();
    }
}
