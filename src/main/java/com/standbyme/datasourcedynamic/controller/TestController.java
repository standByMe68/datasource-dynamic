package com.standbyme.datasourcedynamic.controller;

import com.standbyme.datasourcedynamic.service.TestService;
import org.influxdb.InfluxDB;
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

    @Autowired
    InfluxDB influxDB;

    @GetMapping("test")
    @ResponseBody
    public String test() {
        return influxDB.version();
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
        String taskName = testService.getCalcTaskByIdJcf(taskId,"slave");
        return taskName;
    }
}
