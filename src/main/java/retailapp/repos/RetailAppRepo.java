package retailapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import retailapp.model.RetailApp;

@Repository
public interface RetailAppRepo extends JpaRepository<RetailApp, Long> {

	RetailApp findByClothing(String clothing);

}
