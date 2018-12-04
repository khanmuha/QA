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

	
	@GetMapping("/rest/account/json")
	public List<Account> getAllAccount() {
		return null;
	}
	
	@PostMapping("/rest/account/json")   
	public ResponseEntity<ObjectNode> addAccount(@RequestBody Account newAccount){
		
	return null;
	}
	
	@DeleteMapping("/rest/acccount/json/{id}")
	public ResponseEntity<ObjectNode> deleteAccount(@PathVariable  Long id){
		return null;
	}
			
}
