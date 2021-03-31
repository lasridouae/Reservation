package com.webapp.youcode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.youcode.Dao.UsersDao;
import com.webapp.youcode.Model.Users;

@Service
@Transactional
public class UsersServiceImp  implements UsersService{
	 @Autowired
	    private UsersDao usersDao;

	@Override
	   @Transactional
	public void addUser(Users users) {
		usersDao.create(users);
		
	}

	@Override
	public List<Users> getAll() {
		return usersDao.getAll();
	}

	@Override
	public void delete(long userId) {
		usersDao.remove(userId);
		
	}

	@Override
	public Users getUser(long userId) {
		// TODO Auto-generated method stub
		 return usersDao.getById(userId);
	}

	@Override
	public void update(Users users) {
		 usersDao.update(users);
	}

}
