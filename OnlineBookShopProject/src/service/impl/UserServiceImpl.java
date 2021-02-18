package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import service.UserService;

public class UserServiceImpl implements UserService{
	
	UserDao dao=new UserDaoImpl();

	@Override
	public void add(User user) {
		dao.add(user);
	}

	@Override
	public User checkUsername(String username) {
		return dao.checkUsername(username);
	}

	@Override
	public User login(String username, String password) {
		return dao.login(username, password);
	}

	@Override
	public Boolean checkUsernameExist(String username) {
		User user = dao.checkUsername(username);
		if(user!=null) {
			return true;
		}else {
			return false;
		}
	}

}
