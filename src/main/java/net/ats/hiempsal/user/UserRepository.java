///////////////////////////////////////////////
//
// net.ats.hiempsal.user.UserRepository.java
// is an interface
//
///////////////////////////////////////////////
package net.ats.hiempsal.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository class for <code>User</code> domain objects All method names are compliant
 * with Spring Data naming conventions so this interface can easily be extended for Spring
 * Data. See:
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
 *
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
public interface UserRepository extends Repository<User, Integer> {

	/**
	 * Retrieve an {@link User} from the data store by id.
	 * @param id the id to search for
	 * @return the {@link User} if found
	 */
	@Query("SELECT user FROM User user WHERE user.id =:id")
	@Transactional(readOnly = true)
	User findById(@Param("id") Integer id);
	
	/**
	 * Save an {@link User} to the data store, either inserting or updating it.
	 * @param user the {@link User} to save
	 */
	void save(User user);
}
