package dev.rodrigoguedes.financeiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import dev.rodrigoguedes.core.AppConfiguration;

@SpringBootApplication
@Import(AppConfiguration.class)
@ComponentScan("dev.rodrigoguedes.financeiro")
public class FinanceiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceiroApplication.class, args);
	}

}
