package muhammadkhan.QAdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import muhammadkhan.QAdemo.jpa.AccountRepository;
import muhammadkhan.QAdemo.model.Account;

@RestController
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@GetMapping("/rest/account/json")
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}
	
	@PostMapping("/rest/account/json")   
	public ResponseEntity<ObjectNode> addAccount(@RequestBody Account newAccount){
		
		ObjectNode jsonObject = objectMapper.createObjectNode();
		
		Account savedAccount = accountRepository.save(newAccount);
		if(savedAccount!=null) {			
			jsonObject.put("message", "account has been successfully added");
		} else {
			jsonObject.put("message", "Could not create account");
		}
		
		return new ResponseEntity<ObjectNode>(jsonObject, HttpStatus.OK);
	}
	
	@DeleteMapping("/rest/acccount/json/{id}")
	public ResponseEntity<ObjectNode> deleteAccount(@PathVariable  Long id){
		accountRepository.deleteById(id);
		ObjectNode jsonObject = objectMapper.createObjectNode();
		jsonObject.put("message", "account successfully deleted");
		return new ResponseEntity<ObjectNode>(jsonObject, HttpStatus.OK);
	}
			
}
