package com.G01.onlineFishAuction.restApi;

import com.G01.onlineFishAuction.entities.LoginRequestJSON;
import com.G01.onlineFishAuction.entities.LoginResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.G01.onlineFishAuction.business.*;
import com.G01.onlineFishAuction.entities.User;

import java.util.List;

import com.G01.onlineFishAuction.entities.CooperativeHead;
import com.G01.onlineFishAuction.entities.CooperativeMember;
import com.G01.onlineFishAuction.entities.Customer;
import com.G01.onlineFishAuction.entities.Fisherman;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class Controller {
    private ICustomerService customerService;
    private IUserService userService;
    private ICooperativeMemberService cooperativeMemberService;

    @Autowired
    public Controller(ICustomerService customerService, IUserService userService, 
    		ICooperativeMemberService cooperativeMemberService) 
    {
        this.customerService = customerService;
        this.userService = userService;
        this.cooperativeMemberService = cooperativeMemberService;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomer() {
        return userService.getAllCustomers();
    }
    
    @GetMapping("/fisherman")
    public List<Fisherman> getFisherman() {
    	return userService.getFisherman();
    }
    
    @GetMapping("/admin")
    public List<CooperativeHead> getCooperativeHead() {
    	return userService.getAdmin();
    }
    
    @GetMapping("/members")
    public List<CooperativeMember> getMembers() {
    	return userService.getAllMembers();
    }



    @GetMapping("/loginget/{username}/{password}")
    public LoginResponseJson login(@PathVariable String username, @PathVariable String password) {
    	String userType = "";
    	if ((userType = userService.login(username, password)) != null) {
            return new LoginResponseJson(200, "Successfully logged in!", "/api/login", userType);
        } else {
            return new LoginResponseJson(400, "Not logged in! error occured", "/api/login", userType);
        }
   
    }
    
    @PostMapping("signup/customer")
    public void registerCustomer(@RequestBody Customer customer) {
    	userService.customerRegister(customer);
    }
    
    @PostMapping("signup/member")
    public void registerCooperativeMember(@RequestBody CooperativeMember cooperativeMember) {
    	userService.cooperativeMemberRegister(cooperativeMember);
    }
   
    
    @PostMapping("/register-fisherman")
    public void registerFisherman(@RequestBody Fisherman fisherman) {
    	cooperativeMemberService.registerFisherman(fisherman);
    }

}
