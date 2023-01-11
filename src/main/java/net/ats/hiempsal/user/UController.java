///////////////////////////////////////////////
//
// net.ats.hiempsal.user.UController.java is a
// spring REST Controller
//
///////////////////////////////////////////////
package net.ats.hiempsal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@RestController
@RequestMapping(value = "/api")
public class UController {
	@Autowired
	private UserRepository repo;

	/**
	 * get user by id rest api
	 * @param id: the id of user
	 * @return the user information
	 */
	@GetMapping("/users/{id}")
    public void getUser(@PathVariable("id") int id) {
		System.out.println("#### #### "+repo.findById(id).toString());
    }
	
	/**
	 * 
	 */
	@PostMapping("/users/")
    public void postUser() {
    }
}
