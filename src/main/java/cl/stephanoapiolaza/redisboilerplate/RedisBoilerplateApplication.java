package cl.stephanoapiolaza.redisboilerplate;

import cl.stephanoapiolaza.redisboilerplate.repository.MockRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class RedisBoilerplateApplication {

	private static final Logger log = LogManager.getLogger(RedisBoilerplateApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RedisBoilerplateApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			MockRepository mockRepository = ctx.getBean(MockRepository.class);
			log.debug("Data result {}",mockRepository.findAll().toString());
		};
	}

}
