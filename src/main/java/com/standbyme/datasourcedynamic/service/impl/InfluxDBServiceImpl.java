package com.standbyme.datasourcedynamic.service.impl;

import com.standbyme.datasourcedynamic.config.InfluxDBConfig;
import com.standbyme.datasourcedynamic.domain.InfluxData;
import com.standbyme.datasourcedynamic.service.InfluxDBService;
import org.influxdb.InfluxDB;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.influxdb.impl.InfluxDBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class InfluxDBServiceImpl implements InfluxDBService {


    @Autowired
    InfluxDBConfig influxDBConfig;

    @Autowired
    InfluxDBMapper influxDBMapper;

    @Override
    public QueryResult createDataBase(String databaseName) {
        QueryResult dataBase = influxDBConfig.createDataBase(databaseName);
        return dataBase;
    }

    @Override
    public List<InfluxData> getValueForDatabase(String databaseName) {
        influxDBConfig.selectValue(databaseName);
        /*Query query = new Query("select * from \"2-23300-170109-00003\" WHERE \"time\" > now() - 5m");
        List<InfluxData> query1 = influxDBMapper.query(query, InfluxData.class);*/
        return null;
    }

    @Override
    public Integer insertValues() {
        List<InfluxData> influxDataList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            InfluxData influxData = new InfluxData();
            influxData.setFValue("123");
            influxData.setTime(Instant.now());
            influxData.setName("tag-"+i);
            influxData.setSValue("");
            influxDataList.add(influxData);
        }
        return influxDBConfig.insertBatch(influxDataList);
    }

    @Override
    public String selectRetentionPolicy() {
        influxDBConfig.selectRetentionPolicy();
        return null;
    }
}
