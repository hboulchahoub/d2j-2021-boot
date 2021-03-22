package ma.cigma.pfe.module1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ma.cigma.pfe.module1.models.FactureDTO;

@Controller
@RequestMapping("/fac")
public class FactureController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${rest.url}")
	private String apiUrl;

	@RequestMapping("/home")
	public String home(Model m, @ModelAttribute("k") FactureDTO dto) {
		final String url = apiUrl + "/factures/all";
		System.out.println("Acces Front Controller : "+ url);
		List<FactureDTO> list = restTemplate.getForObject(url, List.class);
		System.out.println("list : " +list);
		m.addAttribute("list", list);
		if (dto == null)
			m.addAttribute("k", new FactureDTO());
		return "indexClt";
	}

	@RequestMapping(path="/crud",params= {"add"})
	public String insert(@ModelAttribute("k") FactureDTO dto, RedirectAttributes ra) {
		final String url = apiUrl + "/factures/create";
		restTemplate.postForObject(url, dto, FactureDTO.class);
		ra.addFlashAttribute("k", dto);
		return "redirect:/fac/home";
	}
	
	// 2- Faire la modification de la factue
	@RequestMapping(path="/crud",params= {"update"})
	public String updateFacture(@ModelAttribute("k") FactureDTO dto, RedirectAttributes ra) {
		final String url = apiUrl + "/factures/update";
		restTemplate.put(url, dto);
		ra.addFlashAttribute("k", dto);
		return "redirect:/fac/home";
	}
	// 1- Charge l'ancienne facture dans le formulaire HTML
	@RequestMapping("/update/{id}")
	public String loadFactureToForm(@PathVariable("id") int id, RedirectAttributes ra) {
		final String url = apiUrl +  "/factures/"+id;
		FactureDTO one = restTemplate.getForObject(url,FactureDTO.class);
		ra.addFlashAttribute("k", one);
		return "redirect:/fac/home";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		final String url = apiUrl + "/factures/"+id;
		restTemplate.delete(url);
		return "redirect:/fac/home";
	}

}
