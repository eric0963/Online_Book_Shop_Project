package service;

import model.User;

public interface UserService {
	
	public void add(User user);
	
	public User checkUsername(String username);
	
	public User login(String username,String password); 
	
	public Boolean checkUsernameExist(String username);

}
