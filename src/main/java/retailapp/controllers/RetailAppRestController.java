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
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;




//import org.springframework.cloud.client.discovery.DiscoveryClient;


import retailapp.model.RetailApp;
import retailapp.repos.RetailAppRepo;
import retailapp.exceptions.ItemNotFoundException;



 
@RestController
@Service
public class RetailAppRestController {

	@Autowired
	RetailAppRepo retailRepo;
	
	//private final RetailAppRepo retailRepo;

	//@Autowired
	//public RetailAppRestController(RetailAppRepo retailRepo) {
	//	this.retailRepo = retailRepo;
	//}
	
	/*
	//@Autowired
	//private DiscoveryClient discoveryClient;


	//@GetMapping("/drink-wine/{wineId}")
	//public Wine drinkSomeWine(@PathVariable int wineId) {
	//	RestTemplate restTemplate = new RestTemplate();
	//	System.out.println("Routed");
		// return new Wine();
	//	List<ServiceInstance> serviceInstances = discoveryClient.getInstances("wine-manager");
	//	if (serviceInstances.size() == 0) {
	//		return null;
	//	}
	//	String serviceURI = String.format("%s/wines/%d", serviceInstances.get(0).getUri().toString(), wineId);
	//	ResponseEntity<Wine> restExchange = restTemplate.exchange(serviceURI, HttpMethod.GET, null, Wine.class);
	//	return restExchange.getBody();
	//}
	*/
	
	
	@GetMapping("/retailApp/search")
	Optional<RetailApp> getItemQueryId(@RequestParam(value="id") Long id) {
		Optional<RetailApp> item = retailRepo.findById(id);
		if (item.isPresent()) {
			return item;
		} else {
			throw new ItemNotFoundException("No item with id: " + id);
		}
	}
	
	@GetMapping(value="/retailApp")
	List<RetailApp> getItem() {
		return retailRepo.findAll();
	}
	
	//@GetMapping(value="/retailApp/{id}")
	//Optional<RetailApp> getItem(@PathVariable("id") Long id) {
	//	return retailRepo.findById(id);
	//}

	@PostMapping(value="/retailApp")
	ResponseEntity<RetailApp> insertProduct(@RequestBody RetailApp name) {
		RetailApp savedProduct = retailRepo.save(name);
		return new ResponseEntity<RetailApp>(savedProduct, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/retailApp/{id}")
	ResponseEntity<RetailApp> deleteClothing(@PathVariable("id") Long id) {
		
		// First fetch an existing product and then delete it. 
		Optional<RetailApp> optionalClothing = retailRepo.findById(id); 
		RetailApp existingClothing=optionalClothing.get();
		// Return the deleted product 
		retailRepo.delete(existingClothing);
		return new ResponseEntity<RetailApp>(HttpStatus.NO_CONTENT) ;		
	}
	
	@PutMapping(value="/retailApp/{id}")
	ResponseEntity<RetailApp> updateClothing(@PathVariable("id") Long id, @RequestBody RetailApp item){
		
		// First fetch an existing product and then modify it. 
		Optional<RetailApp> optionalClothing = retailRepo.findById(id); 
		RetailApp existingClothing=optionalClothing.get();
		// Now update it back 
		existingClothing.setPrice(item.getPrice());
		existingClothing.setName(item.getName());
		RetailApp savedClothing = retailRepo.save(existingClothing);
		// Return the updated product  
		return new ResponseEntity<RetailApp>(savedClothing, HttpStatus.OK);
		}
}
	
	/* 
	@RequestMapping(value = "/{id}.html", method = RequestMethod.GET)
	public ModelAndView RetailApp(@PathVariable("id") long id) {
		return new ModelAndView("item", "item", retailRepo.findById(id));
	}

	@RequestMapping("/list.html")
	public ModelAndView ItemList() {
		return new ModelAndView("itemlist", "items", retailRepo.findAll());
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView add() {
		return new ModelAndView("item", "item", new RetailApp());
	}

	@RequestMapping(value = "/form.html", method = RequestMethod.POST)
	public ModelAndView post(RetailApp retailapp) {
		retailapp = retailRepo.save(retailapp);
		return new ModelAndView("success");
	}

	@RequestMapping(value = "/{id}.html", method = RequestMethod.PUT)
	public ModelAndView put(@PathVariable("id") long id, RetailApp retailapp) {
		retailapp.setId(id);
		retailRepo.save(retailapp);
		return new ModelAndView("success");
	}

	@RequestMapping(value = "/searchForm.html")
	public ModelAndView searchForm() {
		return new ModelAndView("searchForm");
	}

	@RequestMapping(value = "/searchByName.html")
	public ModelAndView search(@RequestParam("query") String query) {
		return new ModelAndView("itemlist", "items",
				retailRepo.findByNameContaining(query));
	}

	@RequestMapping( method = RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable("id") long id) {
		retailRepo.deleteById(id);
		return new ModelAndView("success");
	}


*/

