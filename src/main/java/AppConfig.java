import dao.MockDao;
import dbObjects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.activation.DataSource;

/**
 * Created by arpi on 04.12.2016.
 */
@Configuration
public class AppConfig {
    @Bean
    public PropertyPlaceholderConfigurer ppc(){
        return new PropertyPlaceholderConfigurer();
    }

    @Bean
    public MockDao mockDao(){
        return new MockDao();
    }

    @Bean
    public Movie movie(){
        return new Movie();
    }

    /* @Bean
    @Autowired
    public DataSource dataSource(){
        return new DriverManagerDataSource(jdbc.url, jdbc.username, jdbc.password) {
        }
    }*/
}
