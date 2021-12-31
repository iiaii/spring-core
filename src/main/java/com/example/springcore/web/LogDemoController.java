package com.example.springcore.web;

import com.example.springcore.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(final HttpServletRequest request) {
        String requestUrl = request.getRequestURL().toString();
        myLogger.setRequestURL(requestUrl);
        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
