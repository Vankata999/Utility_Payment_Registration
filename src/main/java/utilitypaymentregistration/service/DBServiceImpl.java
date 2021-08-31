package utilitypaymentregistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import utilitypaymentregistration.Repository.CategoryRepository;
import utilitypaymentregistration.Repository.MerchantRepository;
import utilitypaymentregistration.Repository.SubscriptionRepository;
import utilitypaymentregistration.data.EResponse;
import utilitypaymentregistration.data.Category;
import utilitypaymentregistration.data.Subscription;

@Component
@ComponentScan(basePackages = {"utilitypaymentregistration.Repository"})
public class DBServiceImpl implements DBService {

	@Autowired
	private MerchantRepository merchant;
	@Autowired
	private CategoryRepository category;
	@Autowired
	private SubscriptionRepository subsc;

	public void insertCategoryMerchant(List<Category> cl) {
		category.saveAll(cl);
	}

	public Iterable<Category> getMerchants()
	{
		return category.findAll();
	}
	public void deleteAllMerchants() {
		merchant.deleteAll();
		category.deleteAll();
	}

	public EResponse saveAllSubsc(Subscription subscResponse) {

		EResponse response = new EResponse();
		// autoIncrement with trigger
		try {
		subsc.save(subscResponse);
		boolean have =subsc.existsById(subscResponse.subscriptionId);
		if(have)
		{
			response.setStatus(EResponse.ResponseStatus.SUCCESS);
		}
		else {response.setStatus(EResponse.ResponseStatus.G_ERROR);}
		}
		catch (Exception e) {
		response.setStatus(EResponse.ResponseStatus.G_ERROR);
		}
		return response;
	}

}
