package retailapp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import retailapp.model.RetailApp;

@Repository
public interface RetailAppRepo extends JpaRepository<RetailApp, Long> {

	RetailApp findByName(String name);
	
	//List<RetailApp> findByName(@Param("name") String name);

	//List<RetailApp> findByNameContaining(@Param("name") String name);

}
