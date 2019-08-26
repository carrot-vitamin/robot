package com.github.carrotvitamin.robot;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author yinshaobo on 2019-08-22 15:29
 */
public class MainTest {

    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<>(16);
        map.put("c", "a");
        map.put("a", "a");
        map.put("d", "a");
        map.put("b", "a");
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            System.out.println(s);
        }

        System.out.println("%e8".toUpperCase());


        DecimalFormat decimalFormat = new DecimalFormat("00000");
        int i = 12;
        System.out.println(decimalFormat.format(12) + "");
    }
}
