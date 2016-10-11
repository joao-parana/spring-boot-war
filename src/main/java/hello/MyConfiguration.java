package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
	@Bean
	public MyContextListener executorListener() {
		return new MyContextListener();
	}
}
