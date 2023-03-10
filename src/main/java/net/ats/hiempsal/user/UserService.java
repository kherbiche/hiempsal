///////////////////////////////////////////////
//
// net.ats.hiempsal.user.UserService.java is
// a java class
// 
///////////////////////////////////////////////
package net.ats.hiempsal.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.ats.hiempsal.exception.ResourceException;
import net.ats.hiempsal.util.EMUtils;

/**
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@Transactional("h2dbTM")
@Service
public class UserService {
	@Autowired
	private EMUtils emutils;
	
	public User getUser(int id) throws ResourceException {
		Optional<User> op = emutils.getUserRepo().findById(id);
		if(Boolean.FALSE.equals(op.isPresent()))
			throw new ResourceException("USERnotFound", "User with id:"+id +" not Found", HttpStatus.NOT_FOUND);
		return op.get();
	}
	
	public User saveUser(User u) {
		emutils.getEM().getTransaction().begin();
		emutils.getUserRepo().save(u);
		emutils.getEM().getTransaction().commit();
		return emutils.getUserRepo().find(u).get();
	}
}
