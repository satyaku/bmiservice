package com.fitness.bmiservice.datalayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fitness.bmiservice.datatypes.Member;
import com.fitness.bmiservice.interfaces.DataLayer;

public class AccountManagementDL extends BasicDataLayer implements DataLayer {

	Connection conn = null;

	public boolean createAccount(Member member) {

		initialSetup();
		int entryCount = 0;
		String query = "insert into members values(?,?,?,?,?,?,?,?)";
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, null);
			pst.setString(2, member.getUserName());
			pst.setString(3, member.getName());
			pst.setString(4, member.getDob());
			pst.setString(5, member.getContact());
			pst.setInt(6, member.getHeight());
			pst.setString(7, member.getAddress());
			pst.setString(8, member.getPassword());

			entryCount = pst.executeUpdate();

			terminate();

		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}

		if (entryCount == 1) {
			return true;
		} else {
			return false;
		}
	}

	public List<Member> getAllAccounts() {
		initialSetup();
		String query = "select * from members";
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Member> members = new ArrayList<Member>();
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();

			while (rs.next()) {
				Member member = new Member();

				member.setUserName(rs.getString(2));
				member.setName(rs.getString(3));
				member.setDob(rs.getString(4));
				member.setContact(rs.getString(5));
				member.setHeight(rs.getInt(6));
				member.setAddress(rs.getString(7));

				members.add(member);

			}

		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		terminate();

		return members;
	}

	
	public Member getAccountById(String username) {
		
		List<Member> members = getAllAccounts();
		Member member = null;
		for(Member mem : members){
			if(mem.getUserName().trim().equals(username)){
				member = mem;
			}
		}
		return member;
	}

	@Override
	public void initialSetup() {
		try {

			conn = super.getConnection();

		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}

	@Override
	public void terminate() {
		super.close(conn);
	}

}
