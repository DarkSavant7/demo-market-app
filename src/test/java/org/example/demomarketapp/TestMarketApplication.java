package org.example.demomarketapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
@EnableAutoConfiguration
@Configuration
public class TestMarketApplication {

	@Bean
	@ServiceConnection
	PostgreSQLContainer<?> postgreSQLContainer() {
		return new PostgreSQLContainer<>(DockerImageName.parse("postgres:13.0"))
				.withDatabaseName("demo-market-app")
				.withUsername("admin")
				.withPassword("admin");
	}

	public static void main(String[] args) {
		SpringApplication.from(DemoMarketAppApplication::main).with(TestMarketApplication.class).run(args);
	}

}
