package com.visonarycrafting.vs_mvc;

import com.visonarycrafting.vs_mvc.Dao.ClientRepository;
import com.visonarycrafting.vs_mvc.Dao.CommandRepository;
import com.visonarycrafting.vs_mvc.Entities.Client;
import com.visonarycrafting.vs_mvc.Entities.Command;
import jakarta.validation.Validator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


@SpringBootApplication
public class VsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(VsMvcApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository){
        return args -> {
           /* clientRepository.save(new Client(null,"hamza@tets.com","08877","azer"));
            clientRepository.save(new Client(null,"khalil@tets.com","08877","azer"));
            clientRepository.save(new Client(null,"brahim@tets.com","08877","azer"));*/

            clientRepository.findAll().forEach(c -> {
                System.out.println(c.getEmail());
            });
        };
    }

    @Bean
    public Validator localValidatorFactoryBean() {
        return  new LocalValidatorFactoryBean();
    }

}
