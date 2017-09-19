package springsecurity.exemplo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GerenciadorController {
	
	@RequestMapping(value = "/gerenciador")
	public String manager(){
		return "gerenciador";
	}
	
}
