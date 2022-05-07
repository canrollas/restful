package com.G01.onlineFishAuction.business;

import com.G01.onlineFishAuction.entities.CooperativeMember;
import com.G01.onlineFishAuction.entities.Customer;
import java.util.List;
public interface IUserService {
	String login(String username, String password);
	void logOut();
	void signUp();
	void memberRegister();
	void customerRegister(Customer newCustomer);
	void deleteCustomer(Customer customer);
	void cooperativeMember(CooperativeMember newMember);
	void deleteCooperativeMember(CooperativeMember cooperativeMember);
	List<Customer> getAll();
}
