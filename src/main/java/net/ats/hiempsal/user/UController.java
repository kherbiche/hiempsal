///////////////////////////////////////////////
//
// net.ats.hiempsal.user.UController.java is a
// spring REST Controller
//
///////////////////////////////////////////////
package net.ats.hiempsal.user;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class UController {
	@Autowired
	private UserService service;

	/**
	 * get User by id rest api
	 * @param id: the id of user
	 * @return the user information
	 * @throws Exception 
	 */
	@GetMapping(path="/users/{id}", produces = "application/json")
    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
		return new ResponseEntity<User>(service.getUser(id), HttpStatus.FOUND);
    }
	
	/**
	 * persist {@link User}
	 * @return
	 * @throws MethodArgumentNotValidException 
	 * @throws ConstraintViolationException 
	 */
	@PostMapping("/users")
    public ResponseEntity<User> postUser(@RequestBody @Valid User user) {
		return new ResponseEntity<User>(service.saveUser(user), HttpStatus.CREATED);
    }
}
