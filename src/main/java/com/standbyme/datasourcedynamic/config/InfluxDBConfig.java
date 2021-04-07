package com.standbyme.datasourcedynamic.config;


import com.standbyme.datasourcedynamic.domain.InfluxData;
import okhttp3.OkHttpClient;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.influxdb.impl.InfluxDBImpl;
import org.influxdb.impl.InfluxDBMapper;
import org.influxdb.impl.InfluxDBResultMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.influx.InfluxDbAutoConfiguration;
import org.springframework.boot.autoconfigure.influx.InfluxDbProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
public class InfluxDBConfig {

    private static final String measurement = "sensor";

    private static Logger logger = LoggerFactory.getLogger(InfluxDBConfig.class);

    private static InfluxDB influxDB;

    @Autowired
    InfluxDBProperties influxDBProperties;

    @Bean
    public InfluxDBMapper getInfluxDBMapper() {
        return new InfluxDBMapper(getConnection());
    }

    private InfluxDB getConnection() {
        String user = influxDBProperties.getUser();
        String password = influxDBProperties.getPassword();
        String url = influxDBProperties.getUrl();
        String database = influxDBProperties.getDatabase();
        logger.info("influx connection properties url:{}", url);

        if (influxDB == null) {
            influxDB = InfluxDBFactory.connect(url, user, password);
        }
        influxDB.setDatabase(database);
        return influxDB;
    }


    public QueryResult createDataBase(String databaseName) {
        InfluxDB influxCon = getConnection();
        QueryResult query = influxCon.query(new Query("create database " + databaseName));
        return query;
    }


    public void selectValue(String databaseName) {
        InfluxDB connection = getConnection();
        connection.setDatabase("demo");
        databaseName = "2-23300-170109-00003";
        Query query1 = new Query("select * from " + "\"" + databaseName + "\"","demo");

        String database = query1.getDatabase();
        QueryResult query = connection.query(query1,TimeUnit.HOURS);
        query.getResults();
        System.out.println(query);
    }

    public Integer insertBatch(List<InfluxData> influxDataList) {
        List<String> lines = new ArrayList<>();
        InfluxDB connection = getConnection();
        Point build = null;
        for (InfluxData influxData : influxDataList) {
            build = Point.measurement(InfluxDBConfig.measurement).tag("tag",influxData.getName())
                    .addField("time", influxData.getTime().toString())
                    .addField("fi", influxData.getFValue())
                    .addField("ff", influxData.getSValue()).build();
            lines.add(build.lineProtocol());
        }
        connection.write(lines);

        /*BatchPoints batchPoints = BatchPoints.database(influxDBProperties.getDatabase())
                .consistency(InfluxDB.ConsistencyLevel.ALL).build();*/

        /*Integer count = 0;
        for (InfluxData influxData : influxDataList) {
            Point build = Point.measurement(InfluxDBConfig.measurement)*//*.tag("deviceId",InfluxDBConfig.measurement+count)*//*
                    .addField("time", influxData.getTime().toString())
                    .addField("aa", influxData.getName())
                    .addField("fi", influxData.getFValue())
                    .addField("ff", influxData.getSValue()).build();
            batchPoints.point(build);
            count++;
        }
        connection.write(batchPoints);*/

        return lines.size();
    }

    public QueryResult selectRetentionPolicy() {
        InfluxDB connection = getConnection();
        Query query = new Query("show retention policies on demo");
        //打印命令
        String command = query.getCommand();
        System.out.println(command);
        //打印命令根据url的编码
        String commandWithUrlEncoded = query.getCommandWithUrlEncoded();
        System.out.println(commandWithUrlEncoded);

        //testInlfuxDBMapper();

        testInfluxDBImpl();

        QueryResult show_retention_policies_on_telegraf = connection.query(query);
        return show_retention_policies_on_telegraf;
    }

    public void testInlfuxDBMapper() {
        InfluxDB connection = getConnection();
        InfluxDBMapper influxDBMapper = new InfluxDBMapper(connection);
        List<InfluxData> query = influxDBMapper.query(InfluxData.class);
    }

    public void testInfluxDBImpl() {

        InfluxDBImpl influxDBImpl = new InfluxDBImpl("http://192.168.2.136:8086","root","root",new OkHttpClient.Builder());

        //influxDBImpl.dropRetentionPolicy("h-policy","demo");
        List<String> strings = influxDBImpl.describeDatabases();
        System.out.println(strings);

        InfluxDBResultMapper influxDBResultMapper = new InfluxDBMapper(getConnection());

        InfluxDbAutoConfiguration autoConfiguration = new InfluxDbAutoConfiguration();
    }


}
