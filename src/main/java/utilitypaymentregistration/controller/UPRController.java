package utilitypaymentregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import utilitypaymentregistration.data.ERequest;
import utilitypaymentregistration.data.EResponse;
import utilitypaymentregistration.data.Subscription;
import utilitypaymentregistration.service.DBServiceImpl;
import utilitypaymentregistration.service.EpayServiceImpl;

@RestController
public class UPRController {
	@Autowired
	private EpayServiceImpl service;
	@Autowired
	private DBServiceImpl dbs;
	
	@PostMapping(value = "/checkBill")
	public EResponse checkBill(@RequestBody ERequest request) {
		return  service.checkBill(request);
	}
	
	@PostMapping(value = "/saveSubscr")
	public EResponse save(@RequestBody Subscription subsc) {
		return dbs.saveAllSubsc(subsc);
	}
}
