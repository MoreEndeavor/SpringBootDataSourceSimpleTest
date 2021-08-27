package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DatatSourceSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatatSourceSimpleApplication.class, args);
    }

    /*@Bean
    public ApplicationRunner runner(DataSource dataSource){
        return args -> {
            log.info("dataSource:{}", dataSource);
            Connection connection = dataSource.getConnection();
            log.info("connection: {}", connection);
        };
    }*/

}
