package utilitypaymentregistration.tasks;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;
import utilitypaymentregistration.data.Category;
import utilitypaymentregistration.service.DBService;
import utilitypaymentregistration.service.EpayServiceImpl;

@Configuration
@EnableScheduling
@Slf4j
public class UPRTask {
	@Autowired
	private EpayServiceImpl epayService;
	@Autowired
	private DBService db;
	private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");

//	@Scheduled(fixedDelayString = "${task.interval}")

	public void loadMerchant() {
		log.info("Merchant task executed {}", dataFormat);
		List<Category> listCategory = epayService.getMerchants().asList();
		
		if(!listCategory.isEmpty())
		{
			db.deleteAllMerchants();
			db.insertCategoryMerchant(listCategory);
		}
		else {
			return;  
		}
	}
}
