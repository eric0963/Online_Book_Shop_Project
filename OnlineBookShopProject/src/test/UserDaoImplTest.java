package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;

class UserDaoImplTest {
	
	UserDao dao=new UserDaoImpl();

	@Test
	void testAdd() {
		dao.add(new User(null,"eric111","11111","ww@ww.com"));
	}

	@Test
	void testCheckUsername() {
		System.out.println(dao.checkUsername("eric111"));
	}

	@Test
	void testLogin() {
		System.out.println(dao.login("eric111", "11111"));
	}

}
