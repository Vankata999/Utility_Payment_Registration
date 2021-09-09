package utilitypaymentregistration.data;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import utilitypaymentregistration.data.EResponse.ResponseStatus;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorMessage extends RuntimeException {

	private static final long serialVersionUID = -4875151364873005180L;
	private final ResponseStatus status;

	public ErrorMessage(ResponseStatus status) {
		super();
		this.status = status;
	}

	public ResponseStatus getStatus() {
		return this.status;
	}

	public ErrorMessage(Throwable cause, String message, ResponseStatus status) {
		super(message, cause);
		this.status = status;
	}

	public ErrorMessage(Throwable cause, ResponseStatus status) {
		super(cause);
		this.status = status;
	}

	public ErrorMessage(String message, ResponseStatus status) {
		super(message);
		this.status = status;
	}
}
