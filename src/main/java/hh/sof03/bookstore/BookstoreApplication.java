package hh.sof03.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import hh.sof03.bookstore.domain.Book;

import hh.sof03.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
		Book a = new Book("Introduction to Titles", "Titus Matrix", 1985, "thisIsISBN", 19.99);
		Book b = new Book("Titles: Best Practices", "Margaret Nearwood", 1994, "anotherISBN", 25.25);
		
		repository.save(a);
		repository.save(b);
	};
	}


}
