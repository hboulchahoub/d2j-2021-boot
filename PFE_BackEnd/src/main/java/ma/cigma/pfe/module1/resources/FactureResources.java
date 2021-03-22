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

import ma.cigma.pfe.module1.models.Facture;
import ma.cigma.pfe.module1.service.IFactureService;

@RestController
@RequestMapping("/api/factures")
public class FactureResources {
	@Autowired
	private IFactureService service;
	// Consulter ALL
	@GetMapping(path="/all",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Facture> getAll(){
		return service.selectAll();
	}
	// Consulter One
	@GetMapping(path="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Facture getOne(@PathVariable("id") int id) {
		return service.selectOne(id);
	}
	// Create One
	@PostMapping(path="/create",consumes=MediaType.APPLICATION_JSON_VALUE,
	produces=MediaType.APPLICATION_JSON_VALUE)
	public Facture create(@RequestBody Facture f) {
		return service.insertFacture(f);
	}
	// Update One
	@PutMapping(path="/update",consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Facture update(@RequestBody Facture f) {
		return service.updateFacture(f);
	}
	// Delete One
	@DeleteMapping(path="/{id}")
	public void delete(@PathVariable("id") int id) {
		service.deleteFacture(id);
	}

}
