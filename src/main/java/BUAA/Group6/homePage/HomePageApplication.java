package BUAA.Group6.homePage;

import BUAA.Group6.homePage.model.Expert;
import BUAA.Group6.homePage.repo.ExpertRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HomePageApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomePageApplication.class, args);

	}

}
