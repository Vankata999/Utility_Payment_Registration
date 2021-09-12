package utilitypaymentregistration.tasks;

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

	@Scheduled(fixedDelay = 200000)
	public void loadingPendingDues() {
		ERequest request = new ERequest();
		List<Subscription> s = (List<Subscription>) dbs.sortTable();

		dbs.sortTable().next();

		if (s.isEmpty() == true) {
			return;
		}

		for (Subscription subs : s) {
			EResponse resp = null;
			subs.setCachedDueCheckedDate(subs.cachedDueCheckedDate());
			try {
				resp = esi.checkBill(request);

				if (resp.getStatus() == ResponseStatus.SUCCESS) {
					subs.setCachedDueAmount(resp.getAmount());
					subs.setCachedDueServiceResponse("Success");
				} else {
					subs.setCachedDueServiceResponse("Error");
					subs.setCachedDueErrorCode(resp.getErrorCode());
					;
					subs.setCachedDueErrorDescription(resp.getErrorDes());
					;
				}
			} catch (RuntimeException ex) {

			}
			rep.save(subs);
		}
	}
}
