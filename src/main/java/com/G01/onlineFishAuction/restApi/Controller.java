package com.G01.onlineFishAuction.restApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.G01.onlineFishAuction.business.*;
import com.G01.onlineFishAuction.entities.*;

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

    @GetMapping("/login/{userType}/{username}/{password}")
    public LoginResponseJson getEmployeesById( @PathVariable String username, @PathVariable String password, @PathVariable String userType) {

        if ((userType = userService.login(username, password)) != null) {
            return new LoginResponseJson(200, "Successfully logged in!", "/api/login", userType);
        } else {
            return new LoginResponseJson(400, "Not logged in! error occured", "/api/login", userType);
        }

    }

    @GetMapping("/customers")
    public List<Customer> getCustomer() {
        return userService.getAll();
    }


    @PostMapping("/login")
    public LoginResponseJson login(@RequestBody LoginRequestJSON loginRequestJSON) {
        String userName = loginRequestJSON.getUserName();
        String userPassword = loginRequestJSON.getPassword();
        String userType = loginRequestJSON.getLoginType();
        if (loginRequestJSON.checkApiSecretKeyIsValid()) {
            if ((userType = userService.login(userName, userPassword)) != null) {
                return new LoginResponseJson(200, "Successfully logged in!", "/api/login", userType);
            } else {
                return new LoginResponseJson(400, "Not logged in! error occured", "/api/login", userType);
            }
        }
        return new LoginResponseJson(400, "Unauthorized access!!!", "/api/login", userType);

    }
}
