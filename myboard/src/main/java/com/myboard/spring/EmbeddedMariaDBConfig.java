package com.myboard.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;

import ch.vorburger.exec.ManagedProcessException;
import ch.vorburger.mariadb4j.DBConfigurationBuilder;
import ch.vorburger.mariadb4j.springframework.MariaDB4jSpringService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * EmbeddedMariaDBConfig
 */
@Slf4j // lombok
@Profile("local") // profile이 local일때만 활성화
@Configuration
@Getter
public class EmbeddedMariaDBConfig {

    @Value("${mariaDB4j.databaseName}")
    String databaseName;
    @Value("${spring.datasource.username}")
    String datasourceUsername;
    @Value("${spring.datasource.password}")
    String datasourcePassword;
    @Value("${spring.datasource.driver-class-name}")
    String datasourceDriver;

    @Bean
    MariaDB4jSpringService mariaDB4jSpringService() {
        MariaDB4jSpringService result = new MariaDB4jSpringService();
        log.info("MariaDB SET character - utf8!");
        result.getConfiguration().addArg("--character-set-server=utf8");
        result.getConfiguration().addArg("--collation-server=utf8_general_ci");
        return result;
    }

    @Bean
    @DependsOn("mariaDB4jSpringService")
    DataSource dataSource(MariaDB4jSpringService mariaDB4jSpringService, DataSourceProperties dataSourceProperties)
            throws ManagedProcessException {

        mariaDB4jSpringService.getDB().createDB(databaseName);

        DBConfigurationBuilder config = mariaDB4jSpringService.getConfiguration();

        return DataSourceBuilder.create().username(datasourceUsername).password(datasourcePassword)
                .url(config.getURL(databaseName)).driverClassName(datasourceDriver).build();
    }

}