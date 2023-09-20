package hh.sof03.bookstore.webcontrol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.sof03.bookstore.domain.BookRepository;

@Controller
public class MainController {
	
	@Autowired
	private BookRepository repo;
	
	@GetMapping(value = "/index")
	public String bookStore(Model model) {
		return "bookstore";
	}

	@GetMapping(value = "/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repo.findAll());
		return "booklist";
	}
}

