package com.fitness.bmiservice.business;


import java.util.List;

import com.fitness.bmiservice.datalayer.AccountManagementDL;
import com.fitness.bmiservice.datatypes.Member;
import com.fitness.bmiservice.datatypes.OperationResponse;

public class AccountManagement {
	
	OperationResponse operationResponse = null;
	
	public AccountManagement(){
		operationResponse = new OperationResponse();
	}

	public OperationResponse createAccount(Member member){
		
		boolean res = getDL().createAccount(member);
		if(res){
			operationResponse.setExecuted(true);
			operationResponse.setMessage("Account creation successful for user - "+member.getUserName());
			return operationResponse;
		}else{
			operationResponse.setExecuted(false);
			operationResponse.setMessage("Account creation failed");
			return operationResponse;
		}
		 
	}
	
	public List<Member> getAllAccounts(){
		
		return getDL().getAllAccounts();
		
	}

	private AccountManagementDL getDL() {
		
		return (new AccountManagementDL());
		
	}

	public Member getAccountById(String username) {
		
		return getDL().getAccountById(username);
		
	}

}
