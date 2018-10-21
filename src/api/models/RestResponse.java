/**
 * Connor Low
 * CST-
 * Oct 18, 2018
 * This is my own work.
 */
package api.models;

/**
 * @author speed
 *
 */
public class RestResponse<T> {
	private String message;
	private int status;
	private T data;

	/**
	 * 
	 */
	public RestResponse() {
		super();
		this.message = "";
		this.status = 0;
		this.data = null;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @param message
	 * @param status
	 * @param data
	 */
	public RestResponse(String message, int status, T data) {
		super();
		this.message = message;
		this.status = status;
		this.data = data;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RestResponse [message=" + message + ", status=" + status + ", data=" + data.toString() + "]";
	}

}
