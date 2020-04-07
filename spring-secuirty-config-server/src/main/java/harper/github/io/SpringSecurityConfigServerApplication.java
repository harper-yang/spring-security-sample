package harper.github.io;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringSecurityConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityConfigServerApplication.class, args);
    }

}