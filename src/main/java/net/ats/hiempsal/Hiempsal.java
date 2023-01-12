//////////////////////////////////////////////
//
// net.ats.hiempsal.Heimpsal.java main Class
// Bootstrapping the APP.
//
//////////////////////////////////////////////

package net.ats.hiempsal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <code>Hiempsal<code> is bootstrap app class
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@SpringBootApplication
public class Hiempsal {

	public static void main(String[] args) {
		SpringApplication.run(Hiempsal.class, args);
	}
}
