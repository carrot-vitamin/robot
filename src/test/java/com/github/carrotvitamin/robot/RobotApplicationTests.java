package com.github.carrotvitamin.robot;

import com.github.carrotvitamin.robot.model.RobotResponse;
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
        RobotResponse response = this.moLiService.qa("笑话");
        System.out.println("=======================");
        System.out.println(response.getData());
    }

}
