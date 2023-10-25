package hh.sof03.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof03.bookstore.webcontrol.CategoryController;
import hh.sof03.bookstore.webcontrol.BookController;


// AUTO-GENERATED CLASS USED ONLY FOR CONTROLLER SMOKE TESTS
@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {
	
	@Autowired
	private BookController bookController;
	
	@Autowired
	private CategoryController categoryController;
	
	// What does this do? Test passes even if Controller class is empty (i.e. no code in class).
	@Test
	void smokeTestControllers() {
		assertThat(bookController).isNotNull();
		assertThat(categoryController).isNotNull();
	}


}
