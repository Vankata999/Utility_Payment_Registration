package utilitypaymentregistration;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import utilitypaymentregistration.data.DivideMerchantCategory;
import utilitypaymentregistration.service.DBService;
import utilitypaymentregistration.service.EpayServiceImpl;

@SpringBootTest
class UtilityPaymentRegistrationApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private EpayServiceImpl epayService;

	@Autowired
	DBService service;

	@Test
	public void getMerchant() {
		DivideMerchantCategory merchantList = epayService.getMerchants();

		Assert.assertEquals(2, merchantList.getMerchantList());
	}

	
}
