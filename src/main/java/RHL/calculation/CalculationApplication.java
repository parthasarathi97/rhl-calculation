package RHL.calculation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CalculationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculationApplication.class, args);
	}

}
