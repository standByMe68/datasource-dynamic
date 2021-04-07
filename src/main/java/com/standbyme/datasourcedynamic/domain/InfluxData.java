package com.standbyme.datasourcedynamic.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Measurement(name = "2-23300-170109-00003",database = "demo")
public class InfluxData {

    @Column(name = "time",tag = true)
    private Instant time;

    @Column(name = "aa",tag = true)
    private String name;

    @Column(name = "ff")
    private String fValue;

    @Column(name = "fi")
    private String sValue;


}
