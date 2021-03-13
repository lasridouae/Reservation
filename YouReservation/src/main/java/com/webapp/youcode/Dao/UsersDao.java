package com.webapp.youcode.Dao;

import com.webapp.youcode.model.*;


import java.util.List;

public interface UsersDao {
    public void addUser(Users users);

    public List<Users> listUser();

    public void removeUser(int id);

    public Users getUser(int id);

    public void editUser(Users users);

    public Users findByemail(String email);

}
