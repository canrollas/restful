package com.G01.onlineFishAuction.restApi;

import com.G01.onlineFishAuction.entities.LoginRequestJSON;
import com.G01.onlineFishAuction.entities.LoginResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.G01.onlineFishAuction.business.*;
import com.G01.onlineFishAuction.entities.User;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.G01.onlineFishAuction.entities.CooperativeHead;
import com.G01.onlineFishAuction.entities.CooperativeMember;
import com.G01.onlineFishAuction.entities.Customer;
import com.G01.onlineFishAuction.entities.Fisherman;


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
    public ResponseEntity<List<Customer>> getCustomer() {
        List<Customer> customerList = null;
        try {
            customerList = userService.getAllCustomers();
            return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
            // TODO Exception generic tipi özel exceptionlara yer vermelidir. Önümüzdeki adımlarda düzenlenecektir.
        } catch (Exception e) {
            e.printStackTrace();
            // Eger exception return sırasında fırlatılırsa customerListi dısarıya serve etmemek gerek -> oyüzden null esitleniyor.!
            customerList = null;
            return new ResponseEntity<List<Customer>>(customerList, HttpStatus.INTERNAL_SERVER_ERROR);
        }


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

    @PostMapping("/login")
    public ResponseEntity<LoginResponseJson> login(@RequestBody LoginRequestJSON loginRequestJSON) {
        String userName = loginRequestJSON.getUserName();
        String userPassword = loginRequestJSON.getPassword();
        String userType = loginRequestJSON.getLoginType();
        if (loginRequestJSON.checkApiSecretKeyIsValid()) {
            if ((userType = userService.login(userName, userPassword)) != null) {
                return new ResponseEntity<LoginResponseJson>(new LoginResponseJson("Successfully logged in!", "/api/login", userType), HttpStatus.OK);
            } else {
                return new ResponseEntity<LoginResponseJson>(new LoginResponseJson("Unauthorized access!!!", "/api/login", userType), HttpStatus.UNAUTHORIZED);
            }
        }
        return new ResponseEntity<LoginResponseJson>(new LoginResponseJson("Forbidden!!!", "/api/login", userType), HttpStatus.FORBIDDEN);

    }

    @GetMapping("/loginget/{username}/{password}")
    public ResponseEntity<LoginResponseJson> login(@PathVariable String username, @PathVariable String password) {
        String userType;
        if ((userType = userService.login(username, password)) != null) {
            return new ResponseEntity<LoginResponseJson>(new LoginResponseJson("Successfully logged in!", "/api/login", userType), HttpStatus.OK);
        } else {
            return new ResponseEntity<LoginResponseJson>(new LoginResponseJson("Unauthorized access!!!", "/api/login", userType), HttpStatus.UNAUTHORIZED);
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
        userService.fishermanRegister(fisherman);
    }

}
