package retailpaymentapp.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import retailpaymentapp.controllers.RetailAppPaymentRestController;
import retailpaymentapp.model.RetailPaymentApp;
import retailpaymentapp.repos.RetailPaymentAppRepo;

import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

@SpringBootTest
class RetailPaymentAppRestControllerTest {
	
	/**
	@Autowired
	RetailAppRestController retailAppRestController;
	
	@MockBean
	RetailAppRepo repo;
	
	@Captor
	ArgumentCaptor<RetailApp> captor;

	@Test
	void testCreateclothes() {
		RetailApp clothing = makeClothes();
		RetailApp clothingSaved=makeClothes();
		clothingSaved.setId(1L);
		when(repo.save(any())).thenReturn(clothingSaved);
		RetailApp clothesReturn = retailAppRestController.create(clothing);
		assertEquals(clothesReturn.getId(),1L);
		assertEquals(clothesReturn.getClothing(),"JACKET");
		assertEquals(clothesReturn.getPrice(),BigDecimal.valueOf(40.0));
		assertEquals(clothesReturn.getDate(),"31/12/2024");
		verify(repo, new Times(1)).save(captor.capture());
	}
	
	@Test
	void testGetClothesByCode() {
		RetailApp clothesSaved=makeClothes();
		clothesSaved.setId(1L);
		when(repo.findByClothing("AUTUMN_SALE")).thenReturn(clothesSaved);
		RetailApp clothesReturn = retailAppRestController.getClothes("AUTUMN_SALE");
		assertEquals(clothesReturn.getId(),1L);
		assertEquals(clothesReturn.getClothing(),"AUTUMN_SALE");
		assertEquals(clothesReturn.getPrice(),BigDecimal.valueOf(10.0));
		assertEquals(clothesReturn.getDate(),"31/12/2024");
		verify(repo, new Times(1)).findByClothing("AUTUMN_SALE");
	}
	
	@Test
	void testFindAllclothess() {
		RetailApp clothesSaved=makeClothes();
		clothesSaved.setId(1L);
		ArrayList<RetailApp> clothes = new ArrayList<>();
		clothes.add(clothesSaved);
		when(repo.findAll()).thenReturn(clothes);
		List<RetailApp> clothessFound = retailAppRestController.getAllClothes();
		RetailApp clothesFound = clothessFound.get(0);
		assertEquals(clothesFound.getId(),1L);
		assertEquals(clothesFound.getClothing(),"AUTUMN_SALE");
		assertEquals(clothesFound.getPrice(),BigDecimal.valueOf(10.0));
		assertEquals(clothesFound.getDate(),"31/12/2024");
		verify(repo, new Times(1)).findAll();
	}
	private RetailApp makeClothes() {
		RetailApp clothes = new RetailApp();
		clothes.setClothing("AUTUMN_SALE");
		clothes.setPrice(BigDecimal.valueOf(10.0));
		clothes.setDate("31/12/2024");
		return clothes;
		
	}
	**/

}
