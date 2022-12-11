package telran.java2022;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import telran.java2022.accounting.dao.UserAccountRepository;
import telran.java2022.accounting.dto.UserAccountResponseDto;
import telran.java2022.accounting.dto.UserRegisterDto;
import telran.java2022.accounting.model.UserAccount;
import telran.java2022.accounting.service.UserAccountService;

@SpringBootTest()
@AutoConfigureMockMvc
class ForumServiceSpringsecurityApplicationTests {

    @MockBean
    UserAccountRepository userAccountRepositoryTest;

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void testAddUser() {
	UserAccount user = new UserAccount("User1", "111", "John", "Smith");
	UserAccount expected = new UserAccount("User1", "111", "John", "Smith");

	UserRegisterDto userRegisterDto = modelMapper.map(user, UserRegisterDto.class);

	UserAccountResponseDto actual = userAccountService.addUser(userRegisterDto);
	assertEquals(expected.getLogin(), actual.getLogin());

    }

//    @Test
//    void testWithMockMvc(@Autowired MockMvc mvc) throws Exception {
//	mvc.perform(MockMvcRequestBuilders.post("/account/register")
//		.content(new ObjectMapper().writeValueAsString(new UserRegisterDto("login", "1234", "Sam", "Smith")))
//		.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
//
//	mvc.perform(post("/account/register", new UserRegisterDto("login", "1234", "Sam", "Smith")))
//		.andExpect(status().isOk());
//    }

//    @Test
//    @DisplayName("Adding user test ")
//    void testAddUser() {
//
//	UserRegisterDto user = new UserRegisterDto("login", "1234", "Sam", "Smith");
//	Set<String> roles = new HashSet<>();
//	roles.add("USER");
//	UserAccountResponseDto expected = new UserAccountResponseDto("login", "Sam", "Smith", roles);
//	UserAccountResponseDto actual = userAccountService.addUser(user);
//	assertEquals(expected, actual);
//    }

}
