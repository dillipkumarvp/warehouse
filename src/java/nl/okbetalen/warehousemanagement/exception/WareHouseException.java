package nl.okbetalen.warehousemanagement.exception;

/**
 * Custom exception to wrap other exception.
 * 
 * @author dillipkumar.vp
 *
 */

public class WareHouseException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor
	 */
	public WareHouseException() {
		super();
	}

	/**
	 * Method to add error message to the error appender
	 * 
	 * @param message
	 */
	public WareHouseException(String message) {
		super(message);
	}

	/**
	 * Method to Add throwable/exception object to the error appender
	 * 
	 * @param cause
	 */

	public WareHouseException(Throwable cause) {
		super(cause);
	}

	/**
	 * Method to add Custom message and throwable object to error appender.
	 * 
	 * @param message
	 * @param throwable
	 */
	public WareHouseException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
