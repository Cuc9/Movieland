package com.movieland;

import com.movieland.dao.MockDao;
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
    @Value("$[jdbc.url]")
    String url;

    @Value("$[jdbc.username]")
    String username;

    @Value("$[jdbc.password]")
    String password;

    @Value("${jdbc.driverClassName}")
    String driverClassName;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dm = new DriverManagerDataSource(url,username,password);
        dm.setDriverClassName(driverClassName);
        return dm;
    }

    @Bean
    @Autowired
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        System.out.println("JDBCTemplate created");
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer ppc() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public MockDao MockDao() {
        return new MockDao();
    }

    @Bean
    public Application app(){
        return new Application();
    }
}
