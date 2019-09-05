package com.fitness.bmiservice.rest.interfaces;

import java.util.List;

import com.fitness.bmiservice.datatypes.Member;
import com.fitness.bmiservice.datatypes.OperationResponse;

public interface RestOperations {
	
	public abstract OperationResponse createAccount(Member member);
	public abstract List<Member> getAllAccounts();
	public abstract Member getAccountByUsername(String username);

}
