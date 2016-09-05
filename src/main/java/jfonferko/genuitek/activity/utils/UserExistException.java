package jfonferko.genuitek.activity.utils;

/**
 * Created by JFonferko on 2016-09-02.
 */
public class UserExistException extends Exception {

	public UserExistException() {
	}

	public UserExistException(Throwable cause) {
		super(cause);
	}

	public UserExistException(String msg) {
		super(msg);
	}
}
