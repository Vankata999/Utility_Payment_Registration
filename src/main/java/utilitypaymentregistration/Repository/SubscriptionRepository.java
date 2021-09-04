package utilitypaymentregistration.Repository;


import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import utilitypaymentregistration.data.Subscription;
@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription,Integer>{
	
}
