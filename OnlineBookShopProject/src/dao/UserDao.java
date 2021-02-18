package dao;

import java.awt.print.Book;

import model.User;

public interface UserDao {
	
	public int add(User user);
	
	public User checkUsername(String username);
	
	public User login(String username,String password);

}
