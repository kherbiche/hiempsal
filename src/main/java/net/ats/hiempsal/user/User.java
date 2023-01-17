///////////////////////////////////////////////
//
// net.ats.hiempsal.user.User.java is a JPA
// Entity
//
///////////////////////////////////////////////
package net.ats.hiempsal.user;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import net.ats.hiempsal.model.BaseEntity;
import net.ats.hiempsal.model.Gender;

/**
 * Simple business object & JPA Entity representing 
 * a <code>User<code>.
 *
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "USER_TABLE")
public class User extends BaseEntity {

	@Column(name = "USER_NAME", nullable = false, length = 50)
	private String name;
	@Column(name = "BIRTH_DATE", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;
	@Column(name = "COUNTRY_OF_RESIDENCE", nullable = false, length = 50)
	private String country;
	@Column(name = "PHONE_NUMBER", nullable = true, length = 13)
	private String phone;
	@Enumerated(EnumType.STRING)
	@Column(name = "GENDER", nullable = true, length = 6)
	private Gender gender;
	
	public User() {}

	public String getName() {
		return name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public String getCountry() {
		return country;
	}

	public String getPhone() {
		return phone;
	}

	public Gender getGender() {
		return gender;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
