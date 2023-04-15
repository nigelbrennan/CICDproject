package retailapp;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootTest
@SpringBootApplication
public class RetailApplicationTests {

	//@Test
	//public void contextLoads() {
	//}
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(RetailApplicationTests.class);
		app.setAdditionalProfiles("test");
		app.run(args);
	}


}

