package retailpaymentapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import retailpaymentapp.model.RetailPaymentApp;

public interface RetailPaymentAppRepo extends JpaRepository<RetailPaymentApp, Long> {

	RetailPaymentApp findByClothing(String clothing);

}
