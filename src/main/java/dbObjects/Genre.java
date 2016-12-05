package dbObjects;

import org.springframework.stereotype.Component;

/**
 * Created by arpi on 04.12.2016.
 */
@Component
public class Genre {
    private int id;
    private String name;

    public Genre() {
        System.out.println("Genre was created");
    }
}
