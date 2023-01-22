//////////////////////////////////////////////
//
// net.ats.hiempsal.Heimpsal.java main Class
// Bootstrapping the APP.
//
//////////////////////////////////////////////

package net.ats.hiempsal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * <code>Hiempsal<code> is bootstrap app class
 * 
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@OpenAPIDefinition(info = @Info(title = "API DOC", version = "0.1", description = "Information"))
@SpringBootApplication
public class Hiempsal {

	public static void main(String[] args) {
		SpringApplication.run(Hiempsal.class, args);
	}
}
