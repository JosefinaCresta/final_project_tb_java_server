package com.example.crestananoworldfinalproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.crestananoworldfinalproject.controllerUserTry.User;
import com.example.crestananoworldfinalproject.controllerUserTry.UserRepository;
import com.example.crestananoworldfinalproject.controllerUserTry.UserService;

@SpringBootApplication
public class CrestaNanoworldFinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrestaNanoworldFinalProjectApplication.class, args);
	}



	/*@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**").allowedMethods("*").allowedOrigins("https://josefinacresta.github.io/*", "https://final-project-tb-java-server.herokuapp.com/*");
			}
		};
	}*/

	/*@Bean
	CommandLineRunner run(UserRepository userRepository){
		return args -> {

			userRepository.save(new User("1" ,  "Raymond"));
			userRepository.save(new User("2" ,  "Raymond"));

		};
	}*/

}