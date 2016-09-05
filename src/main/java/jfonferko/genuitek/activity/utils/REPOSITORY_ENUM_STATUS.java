package jfonferko.genuitek.activity.utils;

/**
 * Created by jfonferko on 2016-09-05.
 */
public enum REPOSITORY_ENUM_STATUS {

	SUCCESS("Success", "Success"),
	ERROR("Error", "Error");

	private String code;
	private String name;

	private REPOSITORY_ENUM_STATUS(String code, String name) {
		this.code = code;
		this.name = name;
	}

	static public REPOSITORY_ENUM_STATUS convertTo(String code) {
		if (code != null) {
			for (REPOSITORY_ENUM_STATUS option : values()) {
				if (option.code.equals(code)) {
					return option;
				}
			}
			throw new IllegalArgumentException(
					"No enum pl.nbp.nbe.domain.rach.BLOCKED_AMOUNT_TYPE constant for code " + code);
		}
		throw new NullPointerException(
				"Cannot convert to pl.nbp.nbe.domain.rach.BLOCKED_AMOUNT_TYPE: code is null");
	}

	public String getCode() {
		return this.code;
	}

	public String getName() {
		return this.name;
	}
}
