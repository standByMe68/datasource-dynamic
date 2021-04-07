package com.standbyme.datasourcedynamic.service;

import com.standbyme.datasourcedynamic.domain.InfluxData;
import org.influxdb.dto.QueryResult;

import java.util.List;

public interface InfluxDBService {
    QueryResult createDataBase(String databaseName);

    List<InfluxData> getValueForDatabase(String databaseName);

    Integer insertValues();

    String selectRetentionPolicy();
}
