package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.User;
import service.UserService;

class UserServiceImpl {
	
	UserService s=new service.impl.UserServiceImpl();

	@Test
	void testAdd() {
		s.add(new User(null,"eric222","11111","ww@ww.com"));
	}

	@Test
	void testCheckUsername() {
		System.out.println(s.checkUsername("eric222"));
	}

	@Test
	void testLogin() {
		System.out.println(s.login("admin", "11111"));
	}
	@Test
	void testcheckUsernameExist() {
		System.out.println(s.checkUsernameExist("Terry"));
	}

}
