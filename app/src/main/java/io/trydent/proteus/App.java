package io.trydent.proteus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
@ComponentScan
@EnableJpaRepositories(basePackages = "io.trydent.proteus.mod.repo")
@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
@Import(RepositoryRestMvcConfiguration.class)
public class App extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(App.class);
	}

	public static void main(String ... args) {
		SpringApplication.run(App.class, args);
	}
}
