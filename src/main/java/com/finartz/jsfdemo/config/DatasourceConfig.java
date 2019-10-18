package com.finartz.jsfdemo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/test");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("dbpass");
        return dataSourceBuilder.build();
    }

    @Bean
    public Sql2o sql2o() {
        return new Sql2o(getDataSource());
    }
}
