package com.GheedsAlmanac.GheedsAlmanac.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JpaConfig {

    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url(getDataSourceUrl())
                .username(System.getenv("DB_USERNAME"))
                .password(System.getenv("DB_PASSWORD"))
                .build();
    }

    private String getDataSourceUrl() {
        return "jdbc:postgresql://"
                + System.getenv("DB_HOST") + "/"
                + System.getenv("DB_NAME")
                + "?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";
    }
}