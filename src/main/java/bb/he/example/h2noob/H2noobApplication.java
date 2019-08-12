package bb.he.example.h2noob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * Author: Issam BOUTAIB
 * On: 11.08.2019
 */

@SpringBootApplication
public class H2noobApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2noobApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
