package utilitypaymentregistration.data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subscription_generator")
	@SequenceGenerator(name="client_seq", sequenceName = "client_seq")
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
	public final String insertDate;
	@Column(name = "lastUpdateDate")
	public String lastUpdateDate;
	@Column(name = "cachedDueAmount")
	public  Integer cachedDueAmount;
	@Column(name = "cachedDueCheckedDate")
	public String cachedDueCheckedDate;
	@Column(name = "cachedDueServiceResponse") 
	public  String cachedDueServiceResponse;
	@Column(name = "cachedDueErrorCode")
	public  String cachedDueErrorCode;
	@Column(name = "cachedDueErrorDescription")
	public  String cachedDueErrorDescription;
	@Column(name = "cachedDueId")
	public final Integer cachedDueId;
	
	
	

	public String cachedDueCheckedDate()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		  return dtf.format(now);
	}

	
}
