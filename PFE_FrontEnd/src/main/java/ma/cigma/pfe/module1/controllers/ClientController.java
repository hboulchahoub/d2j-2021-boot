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

import ma.cigma.pfe.module1.models.ClientDTO;

@Controller
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${rest.url}")
	private String apiUrl;

	@RequestMapping("/home")
	public String home(Model m, @ModelAttribute("k") ClientDTO c) {
		final String url = apiUrl + "/all";
		List<ClientDTO> list = restTemplate.getForObject(url, List.class);
		m.addAttribute("list", list);
		if (c == null)
			m.addAttribute("k", new ClientDTO());
		return "indexClt";
	}

	@RequestMapping(path="/crud",params= {"add"})
	public String insert(@ModelAttribute("k") ClientDTO c, RedirectAttributes ra) {
		final String url = apiUrl + "/create";
		restTemplate.postForObject(url, c, ClientDTO.class);
		ra.addFlashAttribute("k", c);
		return "redirect:/clients/home";
	}
	
	@RequestMapping(path="/crud",params= {"update"})
	public String update(@ModelAttribute("k") ClientDTO c, RedirectAttributes ra) {
		final String url = apiUrl + "/update";
		restTemplate.put(url, c);
		ra.addFlashAttribute("k", c);
		return "redirect:/clients/home";
	}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable("id") int id, RedirectAttributes ra) {
		final String url = apiUrl +  "/"+id;
		ClientDTO one = restTemplate.getForObject(url,ClientDTO.class);
		ra.addFlashAttribute("k", one);
		return "redirect:/clients/home";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		final String url = apiUrl + "/"+id;
		restTemplate.delete(url);
		return "redirect:/clients/home";
	}

}
