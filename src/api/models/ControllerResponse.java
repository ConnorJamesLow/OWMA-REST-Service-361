/**
 * Connor Low
 * CST-
 * Sep 28, 2018
 * This is my own work.
 */
package api.models;

/**
 * @author speed
 *
 */
public abstract class ControllerResponse {
	private int status;
	private String message;

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
}
