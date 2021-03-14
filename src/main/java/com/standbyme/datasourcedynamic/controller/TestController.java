package com.standbyme.datasourcedynamic.controller;

import com.standbyme.datasourcedynamic.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("test")
    @ResponseBody
    public String test() {
        return "hello Datasouce-Dynamic !!";
    }

    @GetMapping("calctask")
    @ResponseBody
    public String getCalcTaskById(@RequestParam("id") Integer taskId) {
        String taskName = testService.getCalcTaskById(taskId);
        return taskName;
    }

    @GetMapping("jcf")
    @ResponseBody
    public String getCalcTaskByIdJcf(@RequestParam("id") Integer taskId) {
        String taskName = testService.getCalcTaskByIdJcf(taskId);
        return taskName;
    }
}
