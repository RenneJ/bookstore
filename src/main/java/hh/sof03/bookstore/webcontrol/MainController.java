package hh.sof03.bookstore.webcontrol;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping(value = "/index")
	public String booksPage(Model model) {
		return "bookstore";
	}
}

