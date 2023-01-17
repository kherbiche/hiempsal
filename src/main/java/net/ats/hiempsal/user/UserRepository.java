///////////////////////////////////////////////
//
// net.ats.hiempsal.user.UserRepository.java
// is an interface
//
///////////////////////////////////////////////
package net.ats.hiempsal.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Repository class for <code>User</code> domain objects All method names are compliant
 * with Spring Data naming conventions so this interface can easily be extended for Spring
 * Data. See:
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
 *
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public interface UserRepository extends org.springframework.data.repository.Repository<User, Integer> {

	/**
	 * Retrieve an {@link User} from the data store by id.
	 * @param id the id to search for
	 * @return the {@link User} if found
	 */
	@Query("SELECT user FROM User user WHERE user.id =:id")
	Optional<User> findById(@Param("id") Integer id);
	
	
	/**
	 * Retrieve an {@link User} from the data store by params.
	 * @param u the User to search for
	 * @return the {@link User} if found
	 */
	@Query("SELECT user FROM User user WHERE user.name =:#{#u.name} AND user.birthDate=:#{#u.birthDate} AND"
			+ " user.country=:#{#u.country} AND user.phone=:#{#u.phone} AND user.gender=:#{#u.gender}")
	Optional<User> find(@Param("u") User u);
	
	
	/**
	 * Save an {@link User} to the data store, either inserting or updating it.
	 * @param user the {@link User} to save
	 * @return
	 */
	@Modifying
	@Query(value = "INSERT INTO USER_TABLE(USER_NAME, BIRTH_DATE, COUNTRY_OF_RESIDENCE, PHONE_NUMBER, GENDER) VALUES"
			+ "(:#{#user.name}, :#{#user.birthDate}, :#{#user.country}, :#{#user.phone}, :#{#user.gender.gender()})", nativeQuery = true)
	int save(@Param("user")User user);
}
