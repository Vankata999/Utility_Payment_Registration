package utilitypaymentregistration.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity // (name = "subscription")
@Table(name = "up_subscription")
public class Subscription implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "subscriptionId")
	public Integer subscriptionId;
	@Column(name = "userId")
	public final Integer userId;
	@Column(name = "alias")
	public final String alias;
	@Column(name = "merchantRefNo")
	public final String merchantRefNo;
	@Column(name = "merchantId")
	public final Integer merchantId;
	@Column(name = "merchantName")
	public final String merchantName;
	@Column(name = "customerName")
	public final String customerName;
	@Column(name = "address")
	public final String address;
	@Column(name = "shortDesc")
	public final String short_desc;
	@Column(name = "paymentMethod")
	public final String paymentMethod;
	@Column(name = "paymentAccount")
	public final String paymentAccount;
	@Column(name = "paymentAccountDesc")
	public final String paymentAccountDesc;
	@Column(name = "automaticPayment")
	public final Boolean automatic_payment;
	@Column(name = "maxAmountAuto")
	public final Boolean maxAmountAuto;
	@Column(name = "retryDays")
	public final Integer retryDays;
	@Column(name = "insertDate")
	public String insertDate;
	@Column(name = "lastUpdateDate")
	public String lastUpdateDate;
	@Column(name = "cachedDueAmount")
	public final Integer cachedDueAmount;
	@Column(name = "cachedDueCheckedDate")
	public String cachedDueCheckedDate;
	@Column(name = "cachedDueServiceResponse") 
	public final String cachedDueServiceResponse;
	@Column(name = "cachedDueErrorCode")
	public final String cachedDueErrorCode;
	@Column(name = "cachedDueErrorDescription")
	public final String cachedDueErrorDescription;
	@Column(name = "cachedDueId")
	public final Integer cachedDueId;
	// а ако checkBill върне че е валидно с дата по стара от това което е като ласт ъпдейт? трябва ли да е сървар ерор или е валидно и вземаме сумата
	
	
	

	public void getLasttUpdate() {
		lastUpdateDate = getCachedDueCheckedDate();
	}

	

	public void setId(int i) {
		
		subscriptionId = getSubscriptionId() + i;
	}
}
