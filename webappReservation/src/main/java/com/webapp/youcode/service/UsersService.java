package com.webapp.youcode.service;

import java.util.List;

import com.webapp.youcode.Model.Users;

public interface UsersService {
	
	
	public void addUser(Users users);
    
    public List<Users> getAll();
 
    public void delete(long userId);
 
    public Users getUser(long userId);
 
    public void update(Users users);

}
