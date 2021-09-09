package utilitypaymentregistration.data;

import java.io.Serializable;
import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@XmlRootElement(name = "e_response")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonFormat()
	@NonNull
	private  ResponseStatus status;


	private final Integer amount;
	private final Integer fee;
	private final Integer total;

	@JsonFormat(pattern = "yyyyMMdd")
	@XmlElement(name = "valid_to")
	private final LocalDate validto;

	@XmlElement(name = "short_desc")
	private final String shortDesc;

	@XmlElement(name = "long_desc")
	private final String longDesc;

	@XmlElement(name = "second_Id")
	private final String secondId;

	@XmlElement(name = "error_code")
	@Setter
	private  String errorCode  ;

	@XmlElement(name = "error_des")
	@Setter
	private  String errorDes ;

	@JsonFormat(shape= JsonFormat.Shape.OBJECT)
	public enum ResponseStatus {

		SUCCESS("00"), NOPENDING("62"), NO_SUCH_MERCHANT("14"), INVALID_CODE("58"), lOCKED_CARD("75"),
		TEMPORARA_UNAVAILABLE("80"), G_ERROR("96"), INVALID_SUM("13"), INVALID_FORMAT("805"), DUTY_BLOCKED("70"),
		DOUBLE_MESSAGE("94"), OLD_PENDING("49"), OUT_OF_PERIOD("50"), NO_INFO_FOR_MERCHANT("52");

		private  String code;

		private ResponseStatus(String code) {

			this.code = code;
		}
		@JsonValue
		public String getCode() {
			return code;
		}



	}
}