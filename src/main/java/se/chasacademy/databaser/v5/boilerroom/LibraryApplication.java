package se.chasacademy.databaser.v5.boilerroom;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.chasacademy.databaser.v5.boilerroom.repository.CategoryRepository;
import se.chasacademy.databaser.v5.boilerroom.models.Person;
import se.chasacademy.databaser.v5.boilerroom.repository.PersonRepository;


import java.util.List;
import java.util.Map;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {
    private CategoryRepository categoryRepository;

    private PersonRepository personRepository;
	public LibraryApplication(CategoryRepository categoryRepository,PersonRepository personRepository) {
        this.categoryRepository = categoryRepository;
        this.personRepository = personRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Välkommen till Bibliotek Z");

        System.out.println("CategoryName: Total");
        List<Map<String, Object>> rows = categoryRepository.CountBooksPerCategoryAll();
        rows.stream().forEach((Row)-> {Row.forEach((column,value)->System.out.print(value.toString()+"|"));System.out.println(""); });

        System.out.println("Library: CategoryName: Total");
        rows = categoryRepository.CountBooksPerCategoryAndLibrary();
        rows.stream().forEach((Row)-> {Row.forEach((column,value)->System.out.print(value.toString()+"|"));System.out.println(""); });

        var all = personRepository.findAll();
        System.out.println("Antal personer: " + all.size());

    }
}
