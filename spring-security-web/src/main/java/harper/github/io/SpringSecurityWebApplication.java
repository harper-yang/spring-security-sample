package harper.github.io;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringSecurityWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityWebApplication.class, args);
    }

}
