package hh.sof03.bookstore.webcontrol;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.CategoryRepository;

@CrossOrigin
@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private CategoryRepository catRepo;
	
	// RESTful methods to return data in JSON
	// Return all "Book" entities
	@GetMapping(value="/books")
	public @ResponseBody List<Book> bookListRest(){
		return (List<Book>) bookRepo.findAll();
	}
	
	// Return one "Book" entity with id matching to input parameter, return null if no matches
	@GetMapping(value="/books/{id}")
	public @ResponseBody Optional<Book> getBookRest(@PathVariable("id") Long id) {
		return bookRepo.findById(id);
	}
	
	// ThymeLeaf methods to return HTML
	// TODO: Separate controllers?
	@GetMapping(value = "/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", bookRepo.findAll());
		return "booklist";
	}
	
	@GetMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", catRepo.findAll());
		return "addbook";
	}
	
	@PostMapping(value = "/save")
	public String saveBook(Book book) {
		bookRepo.save(book);
		return "redirect:booklist";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		bookRepo.deleteById(id);
		return "redirect:/booklist";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookRepo.findById(id));
		model.addAttribute("categories", catRepo.findAll());
		return "editbook";
	}
}

