package nl.okbetalen.warehousemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class to initiate the Spring context
 * @author dillipkumar.vp
 *
 */

@SpringBootApplication
public class MyApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}
}