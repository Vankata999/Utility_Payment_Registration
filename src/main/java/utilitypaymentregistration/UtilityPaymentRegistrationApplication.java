package utilitypaymentregistration;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
@ComponentScan("utilitypaymentregistration.data")
public class UtilityPaymentRegistrationApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(UtilityPaymentRegistrationApplication.class, args);
	}
	@Bean
	   public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder
				.setConnectTimeout(Duration.ofMillis(7000))
				.setReadTimeout(Duration.ofMillis(5000))
				.build();
					
	      
	   }

}
