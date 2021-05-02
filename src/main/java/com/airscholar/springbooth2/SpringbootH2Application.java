package com.airscholar.springbooth2;

import com.airscholar.springbooth2.model.Car;
import com.airscholar.springbooth2.model.Owner;
import com.airscholar.springbooth2.model.Person;
import com.airscholar.springbooth2.repository.CarRepository;
import com.airscholar.springbooth2.repository.OwnerRepository;
import com.airscholar.springbooth2.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringbootH2Application {

    private static final Logger logger = LoggerFactory.getLogger(SpringbootH2Application.class);

    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SpringbootH2Application.class, args);

//        PersonRepository personRepository = configurableApplicationContext.getBean(PersonRepository.class);
//
//        Person person = new Person("John", "Doe");
//        personRepository.save(person);


        //One to One relationship
        CarRepository carRepository = configurableApplicationContext.getBean(CarRepository.class);
        OwnerRepository ownerRepository = configurableApplicationContext.getBean(OwnerRepository.class);

        Car car = new Car("Toyota");
        carRepository.save(car);

        Owner owner = new Owner("John", "Doe");
        owner.setCar(car);
        ownerRepository.save(owner);

        Optional<Car> optionalCar = carRepository.findById(1L);
        Optional<Owner> optionalOwner = ownerRepository.findById(2L);

        if(optionalCar.isPresent() && optionalOwner.isPresent()){
            logger.info(optionalCar.get()+ " is owned by "+ optionalCar.get().getOwner());
            logger.info(optionalOwner.get()+ " has a car " + optionalOwner.get().getCar());
        }
    }

}
