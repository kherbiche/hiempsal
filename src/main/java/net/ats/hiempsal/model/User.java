///////////////////////////////////////////////
//
// net.ats.hiempsal.model.User.java is a JPA
// Entity
//
///////////////////////////////////////////////
package net.ats.hiempsal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Simple JavaBean domain object representing a <code>User<code>.
 *
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of= {"name","birthDate", "country", "phone"})
@ToString(of= {"name","birthDate", "country", "phone", "gender"})
@Entity
@Table(name = "USER_TABLE")
public class User extends BaseEntity {

	@Column(name = "USER_NAME", nullable = false, length = 50)
	private String name;
	@Column(name = "BIRTH_DATE", nullable = false)
	private String birthDate;
	@Column(name = "COUNTRY_OF_RESIDENCE", nullable = false, length = 50)
	private String country;
	@Column(name = "PHONE_NUMBER", nullable = true, length = 13)
	private String phone;
	@Enumerated(EnumType.STRING)
	@Column(name = "GENDER", nullable = true, length = 6)
	private Gender gender;
}
