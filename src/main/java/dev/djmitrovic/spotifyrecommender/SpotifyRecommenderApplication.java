package dev.djmitrovic.spotifyrecommender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.yml")
public class SpotifyRecommenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpotifyRecommenderApplication.class, args);
	}

}
