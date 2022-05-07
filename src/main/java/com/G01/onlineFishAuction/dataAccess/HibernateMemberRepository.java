package com.G01.onlineFishAuction.dataAccess;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.G01.onlineFishAuction.entities.CooperativeMember;

@Repository
public class HibernateMemberRepository implements ICooperativeMemberRepository{

	@Override
	public List<CooperativeMember> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CooperativeMember getMember(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void recordMember(CooperativeMember member) {
		// TODO Auto-generated method stub
		
	}

}
