package ma.cigma.pfe.module1.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.cigma.pfe.module1.models.Client;
import ma.cigma.pfe.module1.service.IClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientResources {

	@Autowired
	IClientService service;
	@GetMapping(path= "/all",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Client> getListClient(){
		System.out.println("getListClient... ! ");

		return service.selectAll();
	}
	@GetMapping(path= "/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Client getOneClient(@PathVariable("id") int id){
		System.out.println("getOneClient... ! "+id);

		return service.selectOne(id);
	}
	
	@PostMapping(path= "/add",consumes=MediaType.APPLICATION_JSON_VALUE)
	public Client createClient(@RequestBody Client c){
		System.out.println("create... ! "+c);
		return service.insertClient(c);
	}
	
	@PutMapping(path= "/update",consumes=MediaType.APPLICATION_JSON_VALUE)
	public boolean updateClient(@RequestBody Client c){
		System.out.println("update... ! "+c);
		return service.updateClient(c);
	}
	
	@DeleteMapping(path= "/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public int deleteClient(@PathVariable("id") int id){
		System.out.println("delete... ! "+id);

		return service.deleteClient(id);
	}
}
