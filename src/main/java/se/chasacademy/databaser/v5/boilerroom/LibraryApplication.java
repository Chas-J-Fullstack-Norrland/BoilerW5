package se.chasacademy.databaser.v5.boilerroom;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.chasacademy.databaser.v5.boilerroom.repository.CategoryRepository;
import se.chasacademy.databaser.v5.boilerroom.models.Person;
import se.chasacademy.databaser.v5.boilerroom.repository.PersonRepository;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {
    private CategoryRepository categoryRepository;

    private PersonRepository personRepository;
    private BufferedReader reader;

	public LibraryApplication(CategoryRepository categoryRepository,PersonRepository personRepository) {
        this.categoryRepository = categoryRepository;
        this.personRepository = personRepository;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
	}

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Välkommen till Bibliotek Z");


        boolean running = true;

        while(running){
            switch(reader.readLine()){
                case "all_person" -> all_person();
                case "books_per_category" -> books_per_category();
                case "books_per_category library" -> books_per_category_and_library();
                case "quit" -> running = false;
            }
        }



    }


    public void books_per_category(){
        System.out.println("CategoryName: Total");
        List<Map<String, Object>> rows = categoryRepository.CountBooksPerCategoryAll();
        rows.stream().forEach((Row)-> {Row.forEach((column,value)->System.out.print(value.toString()+"|"));System.out.println(""); });
    }

    public void books_per_category_and_library(){

        System.out.println("Library: CategoryName: Total");
        List<Map<String,Object>> rows = categoryRepository.CountBooksPerCategoryAndLibrary();
        rows.stream().forEach((Row)-> {Row.forEach((column,value)->System.out.print(value.toString()+"|"));System.out.println(""); });
    }

    public void all_person(){
        var all = personRepository.findAll();
        System.out.println("Antal personer: " + all.size());
    }

}



