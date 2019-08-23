package com.github.carrotvitamin.robot;

import com.github.carrotvitamin.robot.service.IMoLiService;
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

}
