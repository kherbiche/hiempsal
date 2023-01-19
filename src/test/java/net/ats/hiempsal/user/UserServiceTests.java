package net.ats.hiempsal.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import net.ats.hiempsal.model.Gender;

/**
 * 
 * @author L KHERBICHE
 * @since
 */
@RunWith(SpringRunner.class)
@DataJpaTest/*(includeFilters = @ComponentScan.Filter(Service.class))*/
public class UserServiceTests {
	@Autowired
	protected UserRepository repo;
	
	@Test
	public void shouldFindUserById() {
		Optional<User> ouser = this.repo.findById(1);
		assertThat(ouser.isPresent()).isTrue();
		assertThat(ouser.get().getName()).isEqualTo("George");

		ouser = this.repo.findById(2);
		assertThat(ouser.isPresent()).isTrue();
		assertThat(ouser.get().getCountry()).isEqualTo("Massachusett");
    }
	@Sql(scripts = {"/clear.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(scripts = {"/clear.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	@Test
	@Transactional
	public void shouldInsertUser() {
		User u = new User();
		u.setName("Sam");
		u.setCountry("Germany");
		u.setBirthDate(LocalDate.of(1999, 07, 14));
		u.setPhone("0044444444400");
		u.setGender(Gender.Male);
		this.repo.save(u);

		u = this.repo.find(u).get();
		assertThat(u.getId()).isNotEqualTo(0);
		assertThat(u.getId()).isEqualTo(1);
    }
}
