package com.fitness.bmiservice.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fitness.bmiservice.datatypes.Member;


public class InternalRestClient {
	
	Client client = ClientBuilder.newClient();
	WebTarget webTarget = null;

	public List<Member> getAllAccounts() {
		/*webTarget = client.target("http://172.31.114.81:8080/bmiservice/webapi/accountManagement/accounts");
		Member member = webTarget.request().get(Member.class);
		System.out.println(member.toString());*/
		
		HttpClient client = HttpClientBuilder.create().build();	


	    HttpGet request = new HttpGet("http://172.31.114.81:8080/bmiservice/accountManagement/accounts");
	    HttpResponse response = null;
		try {
			response = client.execute(request);
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}

	//receiving response
	    System.out.println("Response Code : " 
	                + response.getStatusLine().getStatusCode());

	    BufferedReader rd = null;
		try {
			rd = new BufferedReader(
			    new InputStreamReader(response.getEntity().getContent()));
		} catch (UnsupportedOperationException | IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}

	    StringBuffer result = new StringBuffer();
	    String line = "";
	    try {
			while ((line = rd.readLine()) != null) {
			    result.append(line);
			}
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return null;
	}

}
