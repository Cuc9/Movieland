import dao.MockDao;
import dbObjects.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;
import java.util.Collection;

/**
 * Created by arpi on 04.12.2016.
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        MockDao dao1 = (MockDao) ctx.getBean("MockDao");
        Collection<Movie> col = dao1.getAll();
        System.out.println(col);
    }
}
