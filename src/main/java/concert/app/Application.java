package concert.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by dudin on 29/04/17.
 */
@SpringBootApplication(scanBasePackages = {"concert"})

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(concert.app.Application.class, args);
    }
}