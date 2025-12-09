package se.chasacademy.databaser.v5.boilerroom;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.chasacademy.databaser.v5.boilerroom.models.Person;
import se.chasacademy.databaser.v5.boilerroom.repository.PersonRepository;

import java.util.List;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

    private PersonRepository personRepository;
	public LibraryApplication(PersonRepository personRepository) {
		/* Tom konstruktor för framtiden. */
        this.personRepository = personRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Välkommen till Bibliotek Z");
        var all = personRepository.findAll();
        System.out.println("Antal personer: " + all.size());
	}






}
