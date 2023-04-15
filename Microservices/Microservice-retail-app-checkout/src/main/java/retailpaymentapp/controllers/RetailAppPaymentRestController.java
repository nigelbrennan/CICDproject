package retailpaymentapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
import org.springframework.cloud.client.discovery.DiscoveryClient;

import retailpaymentapp.model.RetailPaymentApp;
import retailpaymentapp.repos.RetailPaymentAppRepo;

@RestController
@Service
public class RetailAppPaymentRestController {

	//@Autowired
	//RetailPaymentAppRepo repo;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	
	//@RequestMapping(value = "/retailpaymentapp", method = RequestMethod.POST)
	//public RetailPaymentApp create(@RequestBody RetailPaymentApp clothing) {
	//	return repo.save(clothing);
	//}


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
}
