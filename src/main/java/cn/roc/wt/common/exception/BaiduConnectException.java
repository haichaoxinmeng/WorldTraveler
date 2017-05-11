package cn.roc.wt.common.exception;

public class BaiduConnectException extends Exception{

	private static final long serialVersionUID = 1L;
	private int errorCode;
	private String errorMsg;
	
	public BaiduConnectException(Throwable throwable){
		super(throwable);
	}
	public BaiduConnectException(String errorMsg){
		super(errorMsg);
	}

    public BaiduConnectException(int errorCode, String errorMsg) {
	        super(errorMsg);
	        this.errorCode = errorCode;
	        this.errorMsg = errorMsg;
	 }
  
    public BaiduConnectException(int errorCode, String errorMsg,Throwable throwable)
    {
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
