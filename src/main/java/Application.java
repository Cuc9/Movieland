import dao.MockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by arpi on 04.12.2016.
 */
public class Application {
    @Autowired
    private static MockDao dao;

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        //MockDao dao1 = (MockDao) ctx.getBean("MockDao");
        System.out.println(dao.getAll());
    }
}
