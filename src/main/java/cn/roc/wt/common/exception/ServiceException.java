package cn.roc.wt.common.exception;

/**
 * Created by Administrator on 2016/3/21.
 */
public class ServiceException extends Exception {

    private static final long serialVersionUID = -6817615404424123515L;

    private int errorCode;
    private String errorMsg;

    public ServiceException(int errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public ServiceException(int errorCode, String errorMsg, Throwable e) {
        super(errorMsg, e);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMsg;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMsg = errorMessage;
    }
}
