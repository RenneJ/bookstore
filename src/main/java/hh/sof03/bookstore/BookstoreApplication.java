package hh.sof03.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import hh.sof03.bookstore.domain.Book;

import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepo, CategoryRepository catRepo) {
		return (args) -> {
			Category catA = new Category("Scifi");
			catRepo.save(catA);
			Category catB = new Category("Non-fiction");
			catRepo.save(catB);	
			
			Book bookA = new Book("Introduction to Titles", "Stephen Monarch", 1985, "123-456-78910-1-1", 19.99, catA);
			bookRepo.save(bookA);
			Book bookB = new Book("Titles: Best Practices", "Margaret Nearwood", 1994, "321-654-01987-1-1", 25.25, catB);
			bookRepo.save(bookB);
		};
	}

}
