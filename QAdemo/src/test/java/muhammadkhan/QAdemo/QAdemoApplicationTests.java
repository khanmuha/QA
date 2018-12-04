package muhammadkhan.QAdemo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import muhammadkhan.QAdemo.model.Account;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class QAdemoApplicationTests {

	@Autowired
	private MockMvc mvc;


	
	@Test
	public void retreiveAllAccount() throws Exception {
		
		this.mvc.perform(get("/rest/account/json")).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));		
		
	}
	
	@Test
	public void addAccount() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Account account = new Account();
		account.setFirstName("Steven");
		account.setLastName("Doe");
		account.setAccountNumber("123456");
        byte[] requestJson =  objectMapper.writeValueAsBytes(account);
		
		this.mvc.perform(post("/rest/account/json")
		.contentType(MediaType.APPLICATION_JSON)
		.content(requestJson))        
        .andExpect(status().isOk());             
        
		
	}
	
	@Test
	public void deleteAccount() throws Exception {
		
		this.mvc.perform(delete("/rest/account/json/1")).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		
	}
}
