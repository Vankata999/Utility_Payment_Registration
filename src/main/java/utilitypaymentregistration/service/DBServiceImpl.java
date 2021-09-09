package utilitypaymentregistration.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import utilitypaymentregistration.Repository.CategoryRepository;
import utilitypaymentregistration.Repository.MerchantRepository;
import utilitypaymentregistration.Repository.SubscriptionRepository;
import utilitypaymentregistration.data.Category;
import utilitypaymentregistration.data.SaveResponse;
import utilitypaymentregistration.data.SaveResponse.saveResponseStatus;
import utilitypaymentregistration.data.Subscription;


@Component
@ComponentScan(basePackages = { "utilitypaymentregistration.Repository" })
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

	public List<Category> getMerchants() {
		return (List<Category>) category.findAll();
	}

	public void deleteAllMerchants() {
		merchant.deleteAll();
		category.deleteAll();
	}

	public SaveResponse saveAllSubsc(Subscription subscRequest) {

		SaveResponse response = new SaveResponse(null, null, null, null, null, 0);
		// autoIncrement with trigger --ready

		subsc.save(subscRequest);
		boolean have = subsc.existsById(subscRequest.getSubscriptionId());
		if (have == false) {
			response = new SaveResponse("200", "Success", "Успех", "", "Success", 1);
			response.setStatus(saveResponseStatus.SUCCESS);
		} else {
			response.setStatus(saveResponseStatus.G_ERROR);
		}

		return response;
	}

	public List<Subscription> getSubscriptions() {
		return subsc.findAll();
	}

	public Pageable sortTable()
	{
		Pageable sortedBycachedDueCheckedDate = 
				  PageRequest.of(0, 20, Sort.by("cachedDueCheckedDate")); 
		return sortedBycachedDueCheckedDate;
	}
	
	//iterate throw table
	public void iteration(HttpServletRequest req)
	{
		String[] values = req.getParameterValues("subscriptionId");
		for(int i=0;i<values.length;i++)
	    {
	
	    }

	}
	

	
	//save to the row of number i
	// Save last data update ---
	// sort by date -- 
	// iterate --
	// consume checkBillAmount --- 
	// ExseptionHandling if chckBill return error -- if error -> we call the same function(recursion)

}
