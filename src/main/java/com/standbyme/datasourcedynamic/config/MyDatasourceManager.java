package com.standbyme.datasourcedynamic.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jca.context.SpringContextResourceAdapter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@Slf4j
public class MyDatasourceManager extends DataSourceTransactionManagerAutoConfiguration {

    @Autowired
    private DataSource dataSource;

    @Bean("transactionManager")
    public DataSourceTransactionManager getDataSourceTransactionManager() {
        log.info(" init Datasource start");
        return new DataSourceTransactionManager(dataSource);
    }
}
