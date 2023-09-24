package hh.sof03.bookstore.webcontrol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;

@Controller
public class MainController {
	
	@Autowired
	private BookRepository bookRepo;
	
	@GetMapping(value = "/index")
	public String bookStore(Model model) {
		return "bookstore";
	}

	@GetMapping(value = "/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", bookRepo.findAll());
		return "booklist";
	}
	
	@GetMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
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
		return "editbook";
	}
}

