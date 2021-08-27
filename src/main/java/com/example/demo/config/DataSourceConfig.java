package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Autowired
    private Environment environment;

    //第一种方式
    /*@Bean
    public DataSource getDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        String dataSourceUrl = environment.getProperty(environment.getProperty("spring.datasource.url"));
        String dataSourceUsername = environment.getProperty("spring.datasource.username");
        String dataSourcePassword = environment.getProperty("spring.datasource.password");

        druidDataSource.setUrl(dataSourceUrl);
        druidDataSource.setUsername(dataSourceUsername);
        druidDataSource.setPassword(dataSourcePassword);
        return druidDataSource;
    }*/

    //第二种方式
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }
}
