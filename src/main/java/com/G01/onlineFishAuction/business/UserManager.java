package com.G01.onlineFishAuction.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.G01.onlineFishAuction.dataAccess.ICooperativeMemberRepository;
import com.G01.onlineFishAuction.dataAccess.ICustomerRepository;
import com.G01.onlineFishAuction.dataAccess.IUserRepository;
import com.G01.onlineFishAuction.entities.CooperativeMember;
import com.G01.onlineFishAuction.entities.Customer;

@Service
public class UserManager implements IUserService {

	ICustomerRepository customerRepository;
	IUserRepository userRepository;
	ICooperativeMemberRepository cooperativeMemberRepository;
	
	@Autowired
	public UserManager(ICustomerRepository customerRepository, IUserRepository userRepository,
			ICooperativeMemberRepository cooperativeMemberRepository) {
		//super();
		this.customerRepository = customerRepository;
		this.userRepository = userRepository;
		this.cooperativeMemberRepository = cooperativeMemberRepository;
	}
	
	

	@Override
	public String login(String username, String password) {
		return userRepository.checkLoginData(username, password);
		
	}

	@Override
	public void logOut() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void signUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void memberRegister() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void customerRegister(Customer newCustomer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cooperativeMember(CooperativeMember newMember) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCooperativeMember(CooperativeMember cooperativeMember) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return customerRepository.getAll();
	}

}
