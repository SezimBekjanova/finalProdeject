package kg.megacom.finalprodeject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.persistence.Embeddable;

@SpringBootApplication
@EnableFeignClients("kg.megacom.finalprodeject.microservice")
public class FinalProdejectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalProdejectApplication.class, args);
    }

}
