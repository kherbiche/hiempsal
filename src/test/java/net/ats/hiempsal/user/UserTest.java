package net.ats.hiempsal.user;

import org.junit.jupiter.api.Test;
import org.springframework.util.SerializationUtils;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author L KHERBICHE
 */
public class UserTest {
	@Test
	void testSerialization() {
		User u = new User();
		u.setName("Izem");
		u.setCountry("France");
		u.setPhone("+336900000");
		u.setId(123);
		User other = (User) SerializationUtils.deserialize(SerializationUtils.serialize(u));
		assertThat(other.getName()).isEqualTo(u.getName());
		assertThat(other.getCountry()).isEqualTo(u.getCountry());
		assertThat(other.getPhone()).isEqualTo(u.getPhone());
		assertThat(other.getId()).isEqualTo(u.getId());
	}
}
