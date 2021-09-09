package utilitypaymentregistration.tasks;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import utilitypaymentregistration.Repository.SubscriptionRepository;
import utilitypaymentregistration.data.ERequest;
import utilitypaymentregistration.data.EResponse;
import utilitypaymentregistration.data.EResponse.ResponseStatus;
import utilitypaymentregistration.data.Subscription;
import utilitypaymentregistration.service.DBServiceImpl;
import utilitypaymentregistration.service.EpayServiceImpl;

@Configuration
@EnableScheduling

public class PendingDuesTask {

	@Autowired
	SubscriptionRepository rep;
	@Autowired
	HttpServletRequest req;
	@Autowired
	DBServiceImpl dbs;
	@Autowired
	EpayServiceImpl esi;
	
	//@Scheduled(fixedDelay = 2000)
	public void loadingPendingDues() {
		ERequest request = new ERequest();
		List<Subscription> s = rep.findAll();

		dbs.sortTable();
	//	String[] values = req.getParameterValues("subscriptionId");

		for(int i = 0;i<s.size();++i) {
			if (esi.checkBill(request).getStatus() == ResponseStatus.SUCCESS) {
				s.get(i);
				Subscription subscription = new Subscription();
				
				subscription.setCachedDueAmount(esi.checkBill(request).getAmount());
				subscription.setCachedDueCheckedDate(subscription.cachedDueCheckedDate());
				subscription.setCachedDueServiceResponse("Success");
				rep.save(subscription);
				//set date and get amount,set service response
			} else {
				s.get(i);
				Subscription subscription = new Subscription();
				subscription.setCachedDueCheckedDate(subscription.cachedDueCheckedDate());
				subscription.setCachedDueServiceResponse("Error");
				subscription.setCachedDueErrorCode(esi.checkBill(request).getErrorCode());;
				subscription.setCachedDueErrorDescription(esi.checkBill(request).getErrorDes());;
				rep.save(subscription);
				//set date,status code,status description,service response
			}
		}
	}
}
