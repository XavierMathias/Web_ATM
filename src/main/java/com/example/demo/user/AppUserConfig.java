package com.example.demo.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class AppUserConfig {

    @Bean
    CommandLineRunner commandLineRunner(AppUserRepository appUserRepository){
        return args -> {
            AppUser user1 = new AppUser("David", "Santos", "dsdsantos973@gmail.com", "", 25, LocalDate.of(1997, JANUARY, 28));
            AppUser user2 = new AppUser("Melina", "Garcia", "tripptravel@gmail.com", "", 23, LocalDate.of(1999, MAY, 12));

            appUserRepository.saveAll(List.of(user1, user2));
        };
    }

}
