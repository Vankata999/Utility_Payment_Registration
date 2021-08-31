package utilitypaymentregistration.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import utilitypaymentregistration.data.DivideMerchantCategory;
import utilitypaymentregistration.data.ERequest;
import utilitypaymentregistration.data.EResponse;

@Slf4j
@Service
public class EpayServiceImpl  {
	@Autowired
	RestTemplate restTemplate = new RestTemplate();
	
	@Value("${bankApi.url}")
	private String bankApiUrl; //http://localhost:8082/bankApi

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.setConnectTimeout(Duration.ofMillis(3000))
					  .setReadTimeout(Duration.ofMillis(3000))
					  .build();
	}

	public DivideMerchantCategory getMerchants() {
		log.info("Get Merchant Data. ");

		DivideMerchantCategory list = restTemplate.getForObject(bankApiUrl + "/getMerchantsData", DivideMerchantCategory.class);
		return list;
	}

	public EResponse checkBill(@RequestBody ERequest eRequest) {
		log.info("Check Bill. ");

		return restTemplate.postForObject(bankApiUrl + "/checkBill", eRequest, EResponse.class);
	}

	public EResponse checkBillBlocked(@RequestBody ERequest eRequest) {
		log.info("Check Bill Blocked. ");

		return restTemplate.postForObject(bankApiUrl + "/checkBillBlocked", eRequest, EResponse.class);
	}

	public EResponse payBill(@RequestBody ERequest eRequest) {
		log.info("Pay Bill. ");

		return restTemplate.postForObject(bankApiUrl + "/payBill", eRequest, EResponse.class);
	}

	public EResponse reverseBill(@RequestBody ERequest eRequest) {
		log.info("Reverse Bill. ");
		
		return restTemplate.postForObject(bankApiUrl + "/reverseBill", eRequest, EResponse.class);
	}

}
