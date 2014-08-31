package io.trydent.proteus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
class Poseidon {
	@RequestMapping("/release")
	public Callable<String> release() { return () -> Proteus.GOD_CRY; }
}

@EnableAutoConfiguration
@ComponentScan
public class Proteus {
	public static final String GOD_CRY = "Release the Kraken";

	public static void main(String ... args) {
		SpringApplication.run(Proteus.class, args);
	}
}
