package net.ats.hiempsal.model;

/**
 * The <code>Gender</code> represents User's gender enumeration type
 * 
 * @author L KHERBICHE
 * @see Class#getEnumConstants()
 * @see java.util.EnumSet
 * @see java.util.EnumMap
 * @since 0.0.1-RELEASE
 */
public enum Gender {
	M("MALE"), F("FEMALE");

	private String gender;

	Gender(String gender) {
		this.gender = gender;
	}
	public String gender() {
		return gender;
	}
}
