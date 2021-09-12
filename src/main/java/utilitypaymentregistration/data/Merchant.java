package utilitypaymentregistration.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true )
@Entity(name = "merchant")
@Table(name = "up_merchants")
public class Merchant implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "merchant_id")
	private final String merchantId;
	
	@Column(name = "category_id", insertable = false, updatable = false)
	private final Integer categoryId;
	
	@Column(name = "merhchant_name")
	private final String merchantName;
	
	@Column(name = "category_name")
	private final String categoryName;
	
	@Column(name = "merchant_desc")
	private final String merchantDesc;
	
	@Column(name = "list_order")
	private int listOrder;
	
	
	/*@JsonProperty("category_name")
	public String getCategoryName()
	{
		return category.getCategoryName(); 
	}*/
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoryy_id")
	private Category category;
	
}
