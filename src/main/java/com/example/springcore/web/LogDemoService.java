package com.example.springcore.web;

import com.example.springcore.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger;

    public void logic(final String id) {
        myLogger.log("service id = " + id);
    }
}
