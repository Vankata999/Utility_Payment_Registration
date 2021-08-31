package utilitypaymentregistration.data;

import java.io.Serializable;
import java.time.LocalDate;



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
	
	private final LocalDate validto;


	private final String shortDesc;

	
	private final String longDesc;


	private final String secondId;

	
	@Setter
	private  String errorCode  ;

	
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
