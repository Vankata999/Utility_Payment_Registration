package utilitypaymentregistration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import utilitypaymentregistration.data.EResponse;
import utilitypaymentregistration.data.Category;
import utilitypaymentregistration.data.Subscription;
@Service
public interface DBService {

	public void insertCategoryMerchant(List<Category> cl);
	public void deleteAllMerchants();
	public EResponse saveAllSubsc(Subscription subscResponse);
	
}
