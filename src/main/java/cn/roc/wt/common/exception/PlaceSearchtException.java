package cn.roc.wt.common.exception;

public class PlaceSearchtException extends Exception {

	private static final long serialVersionUID = 1L;
	private int errorCode;
	private String errorMsg;

	public PlaceSearchtException(Throwable throwable) {
		super(throwable);
	}

	public PlaceSearchtException(String errorMsg) {
		super(errorMsg);
	}

	public PlaceSearchtException(int errorCode, String errorMsg) {
		super(errorMsg);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public PlaceSearchtException(int errorCode, String errorMsg, Throwable throwable) {
		super(throwable);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
