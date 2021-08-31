package utilitypaymentregistration.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ERequest {

	private final String merchantId;
	private final String subscrNumber;
	private final String transactionId;
	private final String dt;
	private final Integer amount;
}
