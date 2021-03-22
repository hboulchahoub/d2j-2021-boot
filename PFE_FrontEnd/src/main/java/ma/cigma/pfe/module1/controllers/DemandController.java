package ma.cigma.pfe.module1.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import ma.cigma.pfe.module1.models.DemandDTO;

/**
 * this controller will validate user's inputs
 * using hibernate-validators. It will be called
 * by main controller of Spring MVC
 * @author Mr.BOULCHAHOUB
 * @date 21.12.2020
 */
@RequestMapping(value="/demands")
@Controller
public class DemandController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${rest.url}")
	private String apiUrl;


	@RequestMapping("/home")
	public String home(Model m) {
		DemandDTO d = new DemandDTO();
		d.setCompte("ZZZZ");
		d.setNb(10);
		m.addAttribute("account", d);
		return "index";
	}
	
	
	@RequestMapping("/add")
	public String insert(@ModelAttribute("account") DemandDTO d,Model m) {
		System.out.println("Appel DemandController...");
		m.addAttribute("result", "sucess");
		return "index";
	}
	public void update(DemandDTO d) {
	}
	public void delete(DemandDTO d) {
	}
	public void select(DemandDTO d) {
		
	}

}
