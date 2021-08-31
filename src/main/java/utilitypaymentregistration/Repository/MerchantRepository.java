package utilitypaymentregistration.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import utilitypaymentregistration.data.Merchant;
@Repository
public interface MerchantRepository extends CrudRepository<Merchant,String> {

}
