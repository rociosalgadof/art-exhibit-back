package com.ironhack.demosecurityjwt;

import com.ironhack.demosecurityjwt.models.user.User;
import com.ironhack.demosecurityjwt.repositories.profile.ProfileRepository;
import com.ironhack.demosecurityjwt.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ArtPortfolioApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtPortfolioApplication.class, args);
    }
    @Autowired
    ProfileRepository profileRepository;
    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/**").allowedMethods("*").allowedOrigins("*");
            }
        };
    }
    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            User rocio = new User("Rocio", "rociosalgado", "1234");
            userService.saveUser(rocio);
        };
    }
}
