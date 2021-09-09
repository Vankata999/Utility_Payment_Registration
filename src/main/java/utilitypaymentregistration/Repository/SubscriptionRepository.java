package utilitypaymentregistration.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import utilitypaymentregistration.data.Subscription;
@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription,Integer>{
	
}
