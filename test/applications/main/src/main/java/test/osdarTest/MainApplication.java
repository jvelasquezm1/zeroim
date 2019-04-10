package test.osdarTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.config.EnableWebFlux;

@Service
@SpringBootApplication
@EnableWebFlux
@EnableCaching
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        System.out.println("Hello");
    }
}
