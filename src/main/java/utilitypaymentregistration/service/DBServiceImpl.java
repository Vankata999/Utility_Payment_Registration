package utilitypaymentregistration.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
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
		// autoIncrement with trigger

		subsc.save(subscRequest);
		boolean have = subsc.existsById(subscRequest.getSubscriptionId());
		if (have == true) {
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

	public Pageable sort()
	{
		Pageable sortedByLastUpdate = 
				  PageRequest.of(0, 20, Sort.by("lastUpdateDate")); 
		return sortedByLastUpdate;
	}
	
	
	// Save last data update
	// sort by date -- 
	// iterate by date 
	// consume checkBillAmount --- 
	// ExseptionHandling if chckBill return error

}
