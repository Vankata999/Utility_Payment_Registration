package utilitypaymentregistration.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true )
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaveResponse {
	
	private saveResponseStatus status;
	private final String httpStatusCode;
	private final String messageCode;
	private final String message;

	private final String statusDesc;
	private final String refNo;
	private final Integer userAuthRule;
	public enum saveResponseStatus {
		SUCCESS("200"),G_ERROR("96");
		
		private  String code;

		private saveResponseStatus(String code) {

			this.code = code;
		}
		@JsonValue
		public String getCode() {
			return code;
		}
	}
	
}
