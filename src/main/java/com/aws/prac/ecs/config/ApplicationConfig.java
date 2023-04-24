package com.aws.prac.ecs.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfig {
//
//    @Bean("dockerHikariConfig")
//    @Profile("docker")
//    public HikariConfig hikariConfigForDocker(){
//        HikariConfig config = new HikariConfig();
//        config.s
//        return config;
//    }
//
//    @Bean("localHikariConfig")
//    public HikariConfig hikariConfigForLocal(){
//        HikariConfig config = new HikariConfig();
//        return config;
//    }
//
//    @Bean
//    public DataSource dataSource(HikariConfig config){
//        return new HikariDataSource(config);
//    }

}
