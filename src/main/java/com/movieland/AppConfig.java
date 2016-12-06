package com.movieland;

import com.movieland.dao.MockDao;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.h2.store.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by arpi on 04.12.2016.
 */

@Configuration
@ComponentScan(basePackages = "com.movieland")
@PropertySource("db/DB.properties")
public class AppConfig {
    @Value("${jdbc.url}")
    String url;

    @Value("${jdbc.username}")
    String username;

    @Value("${jdbc.password}")
    String password;

    @Value("${jdbc.driverClassName}")
    String driverClassName;

    @Bean
    public DataSource dataSource(){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(driverClassName);
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setConnectionTestQuery("SELECT 1");
        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        System.out.println("JDBCTemplate created");
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer ppc() {
        System.out.println("Prop placeholder created");
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Application app(){
        System.out.println("APP created");
        return new Application();
    }
}
