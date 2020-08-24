package com.myboard.spring;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import ch.vorburger.exec.ManagedProcessException;
import ch.vorburger.mariadb4j.DBConfigurationBuilder;
import ch.vorburger.mariadb4j.springframework.MariaDB4jSpringService;

@SpringBootApplication
public class ServerApplication {

    private static final Logger log = LoggerFactory.getLogger(ServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    /**
     * embedded madiaDB start
     *
     * @return
     */
    @Bean
    MariaDB4jSpringService mariaDB4jSpringService() {
        MariaDB4jSpringService result = new MariaDB4jSpringService();
        log.info("MariaDB SET character - utf8!");
        result.getConfiguration().addArg("--character-set-server=utf8");
        result.getConfiguration().addArg("--collation-server=utf8_general_ci");
        return result;
    }

    /**
     * embedded madiaDB settint
     *
     * @param mariaDB4jSpringService
     * @param databaseName
     * @param datasourceUsername
     * @param datasourcePassword
     * @param datasourceDriver
     * @return
     * @throws ManagedProcessException
     */
    @Bean
    DataSource dataSource(MariaDB4jSpringService mariaDB4jSpringService,
            @Value("${mariaDB4j.databaseName}") String databaseName,
            @Value("${spring.datasource.username}") String datasourceUsername,
            @Value("${spring.datasource.password}") String datasourcePassword,
            @Value("${spring.datasource.driver-class-name}") String datasourceDriver) throws ManagedProcessException {
        // Create our database with default root user and no password

        mariaDB4jSpringService.getDB().createDB(databaseName);

        DBConfigurationBuilder config = mariaDB4jSpringService.getConfiguration();

        return DataSourceBuilder.create().username(datasourceUsername).password(datasourcePassword)
                .url(config.getURL(databaseName)).driverClassName(datasourceDriver).build();
    }
}
