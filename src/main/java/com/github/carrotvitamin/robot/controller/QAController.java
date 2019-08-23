package com.github.carrotvitamin.robot.controller;

import com.github.carrotvitamin.robot.model.QARequest;
import com.github.carrotvitamin.robot.model.Response;
import com.github.carrotvitamin.robot.model.RobotResponse;
import com.github.carrotvitamin.robot.model.exception.RobotCheckException;
import com.github.carrotvitamin.robot.service.IMoLiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yinshaobo on 2019-08-23 11:37
 */
@Slf4j
@RestController
@RequestMapping("/qa")
public class QAController {

    @Autowired
    private IMoLiService moLiService;

    @PostMapping
    public Response qa(QARequest request) {
        log.info("请求茉莉系统问答，request=【{}】", request);
        try {
            RobotResponse robotResponse = this.moLiService.qa(request.getQuestion());
            log.info("请求茉莉系统问答成功！request=【{}】，response=【{}】", request, robotResponse);
            return Response.success(robotResponse.getData());
        } catch (RobotCheckException e) {
            log.error("请求茉莉系统问答异常！request=【{}】", request, e);
            return Response.buildErrorResponse(e);
        }
    }
}
