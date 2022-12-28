package org.example;
import org.springframework.context.annotation.*;
import org.example.models.User;
import org.example.service.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.beans.BeanProperty;

@SpringBootApplication
public class SpringBootSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository user, PasswordEncoder encoder){
        return args -> {
            user.save(new User("user","user@gmail.com",encoder.encode("password"),"USER"));
            user.save(new User("admin","admin@gmail.com",encoder.encode("password"),"ADMIN"));
        };
    }
}
