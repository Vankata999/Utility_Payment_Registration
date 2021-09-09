package utilitypaymentregistration.data;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class ERequest {

	private final String merchantId;
	private final String subscrNumber;
	private final String transactionId;
	private final String dt;
	private final Integer amount;
}
