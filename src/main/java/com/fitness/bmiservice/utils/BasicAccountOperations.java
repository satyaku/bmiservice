package com.fitness.bmiservice.utils;

import java.util.ArrayList;
import java.util.List;

import com.fitness.bmiservice.business.AccountManagement;
import com.fitness.bmiservice.constants.ActivityTypeConstants;
import com.fitness.bmiservice.datatypes.Member;
import com.fitness.bmiservice.datatypes.OperationResponse;

public class BasicAccountOperations {

	public OperationResponse execute(String activityTypeCreateAccount, Member member) {

		switch (activityTypeCreateAccount) {

		case ActivityTypeConstants.ACTIVITY_TYPE_CREATE_ACCOUNT:
			return (new AccountManagement().createAccount(member));

		default:
			return (new OperationResponse());
		}
	}

	public List<Member> execute(String activityTypeGetAllAccounts) {

		switch (activityTypeGetAllAccounts) {

		case ActivityTypeConstants.ACTIVITY_TYPE_GET_ALL_ACCOUNTS:
			return (new AccountManagement().getAllAccounts());

		default:
			return (new ArrayList<Member>());
		}
	}

	public Member execute(String activityTypeGetAccountById, String username) {

		switch (activityTypeGetAccountById) {
		
		case ActivityTypeConstants.ACTIVITY_TYPE_GET_ACCOUNT_BY_ID:
			return (new AccountManagement().getAccountById(username));

		default:
			return (new Member());
		}

	}

}
