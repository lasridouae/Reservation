package com.webapp.youcode.Dao;

import com.webapp.youcode.model.*;

import java.util.List;


    public interface UsersDao {
    	
        public Users getById(long id);

        public void create(Users users);

        public List<Users> getAll();

        public void remove(long id);

        public void update(Users users);


    }



