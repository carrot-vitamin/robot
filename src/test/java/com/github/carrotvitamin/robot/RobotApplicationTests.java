package com.github.carrotvitamin.robot;

import com.github.carrotvitamin.robot.sao.tencent.IQaSAO;
import com.github.carrotvitamin.robot.service.moli.IMoLiService;
import com.github.carrotvitamin.robot.service.tencent.IQAService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RobotApplicationTests {

    @Autowired
    private IMoLiService moLiService;

    @Test
    public void contextLoads() throws Exception {
        System.out.println("******************************************");
        System.out.println(this.moLiService.qa("笑话").getData());
        System.out.println("******************************************");
        System.out.println(this.moLiService.qa("观音灵签").getData());
        System.out.println("******************************************");
        System.out.println(this.moLiService.qa("月老灵签").getData());
        System.out.println("******************************************");
        System.out.println(this.moLiService.qa("财神爷灵签").getData());
        System.out.println("******************************************");
        System.out.println(this.moLiService.qa("你叫什么名字啊？").getData());
        System.out.println("******************************************");
    }





    @Autowired
    private IQaSAO qaSAO;

    @Autowired
    private IQAService iqaService;

    @Test
    public void testTencentSAO() throws Exception {
        System.out.println(this.iqaService.qa("早上好", "123"));
    }

}
