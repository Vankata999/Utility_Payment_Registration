package utilitypaymentregistration.tasks;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import utilitypaymentregistration.service.DBService;
import utilitypaymentregistration.service.EpayServiceImpl;

@Component
@Slf4j
public class UPRTask {
	@Autowired
	private EpayServiceImpl epayService;
	@Autowired
	private DBService db;
	private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");

	@Value( "${task.interval}" )
	 @Scheduled(fixedDelayString =  "task.interval"      )   

	public void loadMerchant() {
		log.info("Merchant task executed {}", dataFormat);
        epayService.getMerchants();
		// форматиране и запаметяване в двете таблици
		
	}
}
