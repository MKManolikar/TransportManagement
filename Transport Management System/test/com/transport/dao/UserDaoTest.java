package com.transport.dao;

import static org.junit.Assert.assertEquals;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.transport.model.User;
@RunWith(Parameterized.class)
public class UserDaoTest {
	private int input;
	private int output;
	User user;
	UserDao dao = new UserDao();
	
	
	public UserDaoTest(int input, int output) {
		super();
		this.input = input;
		this.output = output;
	}
	
	@Parameters
	public static Collection testData(){
		Object[][] arObjs=new Object[][]{{"1","1"},{"2","2"},{"3","3"}};
		return Arrays.asList(arObjs);
		
	}



	@Test
	public void test() {
		try {
			user=dao.getUser(input);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		output=user.getUserId();
		assertEquals(output, input);
		
		
	}

}
