package retailapp.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import retailapp.RetailApplication;
import retailapp.controllers.RetailAppRestController;
import retailapp.exceptions.ItemNotFoundException;
import retailapp.model.RetailApp;
import retailapp.repos.RetailAppRepo;

import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;

//import org.apache.commons.httpclient.HttpStatus;
import org.springframework.http.HttpStatus;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;




@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RetailApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class RetailAppRestControllerTest {
	
	//@Autowired
	//RetailAppRestController retailAppRestController;
	
	//@MockBean
	//RetailAppRepo repo;
	
	//@Captor
	//ArgumentCaptor<RetailApp> captor;
	
	@Mock
	private RetailAppRepo retailRepo;

    @InjectMocks
    private RetailAppRestController retailAppRestController;
    
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetItemQueryId() {
        Long itemId = 123L;
        RetailApp retailApp = new RetailApp();
        retailApp.setId(itemId);
        Optional<RetailApp> optionalRetailApp = Optional.of(retailApp);

        when(retailRepo.findById(itemId)).thenReturn(java.util.Optional.ofNullable(retailApp));

        Optional<RetailApp> result = retailAppRestController.getItemQueryId(itemId);

        assertNotNull(result);
        assertTrue(result.isPresent());
        assertEquals(optionalRetailApp.get(), result.get());
	    }
    
    @Test
    public void testGetItemQueryIdThrowsItemNotFoundException() {
        Long itemId = 123L;
        Optional<RetailApp> optionalRetailApp = Optional.empty();

        when(retailRepo.findById(itemId)).thenReturn(optionalRetailApp);

        Exception exception = assertThrows(ItemNotFoundException.class, () -> {
            retailAppRestController.getItemQueryId(itemId);
        });

        assertEquals("No item with id: " + itemId, exception.getMessage());
    }
    
    @Test
    public void testGetItem() {
        List<RetailApp> expectedList = new ArrayList<>();
        RetailApp retailApp1 = new RetailApp();
        retailApp1.setId(1L);
        RetailApp retailApp2 = new RetailApp();
        retailApp2.setId(2L);
        expectedList.add(retailApp1);
        expectedList.add(retailApp2);

        when(retailRepo.findAll()).thenReturn(expectedList);

        List<RetailApp> actualList = retailAppRestController.getItem();

        assertEquals(expectedList.size(), actualList.size());
        assertEquals(expectedList.get(0).getId(), actualList.get(0).getId());
        assertEquals(expectedList.get(1).getId(), actualList.get(1).getId());
    }
    
    
    @Test
    public void testInsertProduct() {
        // Create a new product to save
        RetailApp productToSave = new RetailApp();
        productToSave.setName("Test Product");
        productToSave.setPrice(9.99);

        // Create a mock response from the repository when saving the product
        RetailApp savedProduct = new RetailApp();
        savedProduct.setId(1L);
        savedProduct.setName("Test Product");
        savedProduct.setPrice(9.99);
        when(retailRepo.save(any(RetailApp.class))).thenReturn(savedProduct);

        // Call the insertProduct method and verify the response
        ResponseEntity<RetailApp> response = retailAppRestController.insertProduct(productToSave);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(savedProduct, response.getBody());

        // Verify that the product was saved using the repository mock
        verify(retailRepo).save(productToSave);
    }
    

	//@Test
	//void testCreateitem() {
		//RetailApp clothing = makeClothes();
		//RetailApp clothingSaved=makeClothes();
		//clothingSaved.setId(1L);
		//when(repo.save(any())).thenReturn(clothingSaved);
		//RetailApp clothesReturn = retailAppRestController.create(clothing);
		//assertEquals(clothesReturn.getId(),3);
		//assertEquals(clothesReturn.getClothing(),"JUMPER");
		//assertEquals(clothesReturn.getPrice(),45.0);
		//assertEquals(clothesReturn.getDate(),"31/12/2024");
		//verify(repo, new Times(1)).save(captor.capture());
	//}
	

	//@Test
	//void testGetClothesByCode(){
			//RetailApp clothesSaved=makeClothes();
		//	clothesSaved.setId(1L);
			//when(repo.findByClothing("AUTUMN_SALE")).thenReturn(clothesSaved);
			//RetailApp clothesReturn = retailAppRestController.getClothing("AUTUMN_SALE");
			//assertEquals(clothesReturn.getId(),1L);
			//assertEquals(clothesReturn.getClothing(),"AUTUMN_SALE");
			//assertEquals(clothesReturn.getPrice(),BigDecimal.valueOf(10.0));
			//assertEquals(clothesReturn.getDate(),"31/12/2024");
			//verify(repo, new Times(1)).findByClothing("AUTUMN_SALE");

	//}

	//@Test
	//void testGetClothesByCode() {
		//RetailApp clothesSaved=makeClothes();
		//clothesSaved.setId(1L);
		//when(repo.findByClothing("AUTUMN_SALE")).thenReturn(clothesSaved);
		//RetailApp clothesReturn = retailAppRestController.getClothes("AUTUMN_SALE");
		//assertEquals(clothesReturn.getId(),1L);
		//assertEquals(clothesReturn.getClothing(),"AUTUMN_SALE");
		//assertEquals(clothesReturn.getPrice(),BigDecimal.valueOf(10.0));
		//assertEquals(clothesReturn.getDate(),"31/12/2024");
		//verify(repo, new Times(1)).findByClothing("AUTUMN_SALE");
	//}
	
	//@Test
	//void testFindAllclothess() {
		//RetailApp clothesSaved=makeClothes();
		//clothesSaved.setId(1L);
		//ArrayList<RetailApp> clothes = new ArrayList<>();
		//clothes.add(clothesSaved);
		//when(repo.findAll()).thenReturn(clothes);
		//List<RetailApp> clothessFound = retailAppRestController.getAllClothes();
		//RetailApp clothesFound = clothessFound.get(0);
		//assertEquals(clothesFound.getId(),1L);
		//assertEquals(clothesFound.getClothing(),"AUTUMN_SALE");
		//assertEquals(clothesFound.getPrice(),BigDecimal.valueOf(10.0));
		//assertEquals(clothesFound.getDate(),"31/12/2024");
		//verify(repo, new Times(1)).findAll();
//	}
	//private RetailApp makeClothes() {
		//RetailApp clothes = new RetailApp();
		//clothes.setClothing("AUTUMN_SALE");
		//clothes.setPrice(BigDecimal.valueOf(10.0));
		//clothes.setDate("31/12/2024");
		//return clothes;
		
	//}

	//@Autowired
	//private RetailAppRepo retailRepository;

	//@Value("${local.server.port}")
	//private int serverPort;

	//private RetailApp Pixel;

	//private RestTemplate restTemplate;

	//@Before
	//public void setup() {
	//	Pixel = retailRepository.findByName("Pixel");
	//	restTemplate = new RestTemplate();
	//}

	//@Test
	//public void IsItemReturned() {
		
	//}

	//@Test
   // public void testGetItemEndpoint() {
   //     ResponseEntity<RetailApp> response = restTemplate.getForEntity("/retailapp/1", RetailApp.class);
   //     assertEquals(HttpStatus.OK, response.getStatusCode());
   // }
 
	 
	//private String retailappURL() {
	//	return "http://localhost:" + serverPort;
	//}

	//@Test
	//public void IsItemReturnedbyID() {
	//	Long body =  Pixel.getId();
	//	assertThat(body, equalTo(Pixel));
	//}


	


}
