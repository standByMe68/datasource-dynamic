package com.standbyme.datasourcedynamic.controller;

import com.standbyme.datasourcedynamic.config.InfluxDBConfig;
import com.standbyme.datasourcedynamic.config.InfluxDBProperties;
import com.standbyme.datasourcedynamic.domain.InfluxData;
import com.standbyme.datasourcedynamic.service.InfluxDBService;
import org.influxdb.dto.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/influx")
public class InfluxDBController {

    @Autowired
    InfluxDBService influxDBService;

    @GetMapping("/create/{databaseName}")
    public String test(@PathVariable("databaseName") String databaseName) {
        QueryResult queryResult = influxDBService.createDataBase(databaseName);
        return queryResult.getError();
    }


    @GetMapping("/value/{databaseName}")
    public List<InfluxData> getValue(@PathVariable("databaseName") String databaseName) {
        List<InfluxData> valueForDatabase = influxDBService.getValueForDatabase(databaseName);
        return valueForDatabase;
    }

    @GetMapping("/insert")
    public Integer insertValues() {
        return influxDBService.insertValues();
    }
    @GetMapping("/retention")
    public String selectRetentionPolicy() {
        return influxDBService.selectRetentionPolicy();
    }
}
