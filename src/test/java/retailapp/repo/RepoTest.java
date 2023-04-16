package retailapp.repo;


//import static org.hamcrest.Matchers.*;
//import static org.junit.Assert.*;

//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import retailapp.RetailApplication;
import retailapp.repos.RetailAppRepo;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = RetailApplication.class, webEnvironment = WebEnvironment.NONE)
//@ActiveProfiles("test")
public class RepoTest {
	

	@Autowired
	private RetailAppRepo retailRepo;

	//@Test
	//public void AreAllIPhonesReturned() {
	//}

}
