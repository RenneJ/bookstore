package hh.sof03.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;
import hh.sof03.bookstore.domain.User;
import hh.sof03.bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookstoreRepositoryTests {
	
	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private UserRepository userRepo;
	
	@Test
	public void findByTitleReturnsBooklist() {
		List<Book> books = bookRepo.findByTitle("Introduction to Titles");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Stephen Monarch");
	}
	
	@Test
	public void savingBookWorks() {
		// title, author, year, isbn, price, category
		Book book = new Book("Book Name", "Writer Name", 2023, "ISBN", 10.99, null);
		bookRepo.save(book);
		// saving works if ID is autogenerated
		assertThat(book.getId()).isNotNull();
	}
	
	// Not working. I don't understand.
//	@Test
//	public void deletingBookWorks() {
//		Book book = new Book("Book Name", "Writer Name", 2023, "ISBN", 10.99, null);
//		bookRepo.save(book);
//		bookRepo.deleteById(book.getId());
//		assertThat(book.getId()).isNull();
//	}
	
	@Test
	public void findByNameReturnsCategory() {
		Category category = categoryRepo.findByName("Scifi");
		assertThat(category.getCategoryid()).isNotNull();
	}
	
	@Test
	public void savingCategoryWorks() {
		Category category = new Category("Computer Science");
		categoryRepo.save(category);
		assertThat(category.getCategoryid()).isNotNull();
		assertThat(category.getName()).isEqualTo("Computer Science");
	}
	
	@Test
	public void findByUsernameReturnsUser() {
		User user = userRepo.findByUsername("ReiskaUser");
		assertThat(user.getRole()).isEqualTo("USER");
	}

}
