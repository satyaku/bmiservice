package com.fitness.bmiservice.implementation;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fitness.bmiservice.constants.ActivityTypeConstants;
import com.fitness.bmiservice.datatypes.Member;
import com.fitness.bmiservice.datatypes.OperationResponse;
import com.fitness.bmiservice.rest.interfaces.RestOperations;
import com.fitness.bmiservice.utils.BasicAccountOperations;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("accountManagement")
public class BmiServiceImpl extends BasicAccountOperations implements RestOperations{

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     * @throws SQLException 
     */
    

	@Override
	@POST
	@Path("account")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public OperationResponse createAccount(Member member){
		
		return super.execute(ActivityTypeConstants.ACTIVITY_TYPE_CREATE_ACCOUNT, member);
		
	}

	@Path("accounts")
	@Override
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Member> getAllAccounts() {
		
		return super.execute(ActivityTypeConstants.ACTIVITY_TYPE_GET_ALL_ACCOUNTS);
	}

	@Override
	@Path("account/{username}")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Member getAccountByUsername(@PathParam("username") String username) {
		
		return super.execute(ActivityTypeConstants.ACTIVITY_TYPE_GET_ACCOUNT_BY_ID, username);
	}
}
