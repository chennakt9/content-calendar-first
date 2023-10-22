package com.chenna.contentcalendarfirst;

import com.chenna.contentcalendarfirst.config.ContentCalendarProperties;
import com.chenna.contentcalendarfirst.model.Content;
import com.chenna.contentcalendarfirst.model.Status;
import com.chenna.contentcalendarfirst.model.Type;
import com.chenna.contentcalendarfirst.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableConfigurationProperties(ContentCalendarProperties.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ContentRepository contentRepository) {
		return args -> {
			Content c = new Content(null,
				"My first blog post",
				"My first blog post",
				Status.IDEA,
				Type.ARTICLE,
				LocalDateTime.now(),
				null,
				"");
			contentRepository.save(c);		};
	}

}