package com.airscholar.springbooth2;

import com.airscholar.springbooth2.model.Person;
import com.airscholar.springbooth2.repository.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootH2Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SpringbootH2Application.class, args);

        PersonRepository personRepository = configurableApplicationContext.getBean(PersonRepository.class);

        Person person = new Person("John", "Doe");
        personRepository.save(person);


    }

}
