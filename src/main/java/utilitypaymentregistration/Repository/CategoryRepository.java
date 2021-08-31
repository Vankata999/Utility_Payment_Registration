package utilitypaymentregistration.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import utilitypaymentregistration.data.Category;
@Repository
public interface CategoryRepository  extends CrudRepository<Category, Integer>{

}
