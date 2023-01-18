package net.ats.hiempsal.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author L KHERBICHE
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HiempsalIntegrationTests {
	
	@LocalServerPort
	int port;
	@Autowired
	private UserRepository rep;
	@Autowired
	private RestTemplateBuilder builder;

	@Test
	void testFindAll() throws Exception {
		rep.findById(1);
		rep.findById(1); // served from cache
	}
	
	@Test
	void testUserDetails() {
		RestTemplate template = builder.rootUri("http://localhost:" + port).build();
		ResponseEntity<User> result = template.exchange(RequestEntity.get("/api/users/1").build(), User.class);
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.FOUND);
	}
}
