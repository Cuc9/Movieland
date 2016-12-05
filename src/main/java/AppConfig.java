import dao.MockDao;
import dbObjects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.convert.Property;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.activation.DataSource;
import java.util.Properties;

/**
 * Created by arpi on 04.12.2016.
 */
@ComponentScan(basePackages = "..")
@Configuration
@PropertySource(value = {"DB.property"})
public class AppConfig {
    @Value("$[jdbc.url]")
    String url;

    @Value("$[jdbc.username]")
    String username;

    @Value("$[jdbc.password]")
    String password;

    @Bean
    public static PropertySourcesPlaceholderConfigurer ppc() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public MockDao MockDao (){
        return new MockDao();
    }

 /*   @Bean
    @Autowired
    public DataSource dataSource(){
        return new DriverManagerDataSource(this.url, this.username, this.password);
    }*/
}
