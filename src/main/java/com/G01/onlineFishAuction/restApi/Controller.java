package com.G01.onlineFishAuction.restApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.G01.onlineFishAuction.business.*;
import com.G01.onlineFishAuction.entities.User;
import java.util.List;
import com.G01.onlineFishAuction.entities.Customer;


@RestController
@RequestMapping("/api")
public class Controller {
	private ICustomerService customerService;
	private IUserService userService;
	
	@Autowired
	public Controller(ICustomerService customerService, IUserService userService) {
		super();
		this.customerService = customerService;
		this.userService = userService;
	}
	
	@GetMapping("/customers")
	public List<Customer> getCustomer(){
		return userService.getAll();
	}
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		System.out.println(user.getUsername());
		String userType;
		if((userType = userService.login(user.getUsername(), user.getPassword())) == null) {
			return "invalid login attempt";
		}else {
			return userType;
		}
	}	
	

}
