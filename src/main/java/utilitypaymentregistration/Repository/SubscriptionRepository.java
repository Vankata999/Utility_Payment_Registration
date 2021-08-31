package utilitypaymentregistration.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import utilitypaymentregistration.data.Subscription;
@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription,Integer>{

}
