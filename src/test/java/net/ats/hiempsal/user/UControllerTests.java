package net.ats.hiempsal.user;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.ats.hiempsal.model.Gender;

/**
 * Test class for the {@link UController}
 * @author L KHERBICHE
 * @since
 */
@WebMvcTest(value = UController.class)
public class UControllerTests {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private UserService service;
	@Autowired
    private ObjectMapper mapper;
	
	@BeforeEach
	void setup() {
		User u = new User();
		u.setId(3);
		u.setName("Micipsa");
		u.setCountry("France");
		u.setGender(Gender.Male);
		u.setPhone("+33666666666");
		u.setBirthDate(LocalDate.of(2000, 10, 01));
		given(this.service.getUser(3)).willReturn(u);
	}
	@Test
	void testShowResourcesUser() throws Exception {
		ResultActions actions = mockMvc.perform(get("/api/users/3").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isFound());
		actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id").value(3))
				.andExpect(jsonPath("$.name").value("Micipsa"));
	}
	@Test
	void testProcessCreationSuccess() throws Exception {
		User u = new User();
		u.setName("Mastanabal");
		u.setCountry("France");
		u.setGender(Gender.Male);
		u.setPhone("+33666666666");
		u.setBirthDate(LocalDate.of(103, 10, 01));
		
		Mockito.when(service.saveUser(Mockito.any(User.class))).thenReturn(u);
		
		MvcResult res = mockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON)
	            .content(mapper.writeValueAsString(u).getBytes(StandardCharsets.UTF_8))
	            .accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andReturn();
		Assertions.assertThat(res).isNotNull();
        String userJson = res.getResponse().getContentAsString();
        Assertions.assertThat(userJson).isEqualToIgnoringCase(mapper.writeValueAsString(u));
	}
}
