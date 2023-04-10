package retailapp.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import retailapp.model.RetailApp;
import retailapp.repos.RetailAppRepo;

@RestController
@Service
//@RequestMapping("/retailappapi/v1")
public class RetailAppRestController {

	@Autowired
	RetailAppRepo repo;
	
	@GetMapping(value="/retailappapi")
	List<RetailApp> getClothing() {
		return repo.findAll();
	}
	
	@GetMapping("/retailappapi/{id}")
	Optional<RetailApp> getClothing(@PathVariable("id") Long id) {
		return repo.findById(id);
	}

	@PostMapping(value = "/retailappapi")
	ResponseEntity<RetailApp> insertProduct(@RequestBody RetailApp clothing) {
		RetailApp savedProduct = repo.save(clothing);
		return new ResponseEntity<RetailApp>(savedProduct, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/retailappapi/{id}")
	ResponseEntity<RetailApp> deleteClothing(@PathVariable("id") Long id) {
		
		// First fetch an existing product and then delete it. 
		Optional<RetailApp> optionalClothing = repo.findById(id); 
		RetailApp existingClothing=optionalClothing.get();
		// Return the deleted product 
		repo.delete(existingClothing);
		return new ResponseEntity<RetailApp>(HttpStatus.NO_CONTENT) ;		
	}
	
	@PutMapping(value="/retailappapi/{id}")
	ResponseEntity updateClothing(@PathVariable("id") Long id, @RequestBody RetailApp clothing) {
		
		// First fetch an existing product and then modify it. 
		Optional<RetailApp> optionalClothing = repo.findById(id); 
		RetailApp existingClothing=optionalClothing.get();
		// Now update it back 
		existingClothing.setPrice(clothing.getPrice());
		existingClothing.setClothing(clothing.getClothing());
		RetailApp savedClothing = repo.save(existingClothing) ;
		// Return the updated product  
		return new ResponseEntity<RetailApp>(savedClothing, HttpStatus.OK) ;		
	}

}
