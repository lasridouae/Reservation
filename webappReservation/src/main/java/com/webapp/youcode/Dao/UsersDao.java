package com.webapp.youcode.Dao;

import java.util.List;

import com.webapp.youcode.Model.*;


public interface UsersDao {

	public Users getById(long id);
	
	public void create(Users users);

	public List<Users> getAll();

	public void remove(long id);

	public void update(Users users);

	public void addRole(Roles roles);

	public Roles getRoleById(long id);

	public List<Roles> getAllRoles();
}
