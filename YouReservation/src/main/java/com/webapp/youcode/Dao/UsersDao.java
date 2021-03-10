package com.webapp.youcode.Dao;

import com.webapp.youcode.model.*;


import java.util.List;

public interface UsersDao {
    public void addUser(Users user);

    public List<Users> listUser();

    public void removeUser(int id);

    public Users getUser(int id);


    public void editUser(Users user);

    public Users findByLogin(String email);

    public void addRole(Roles roles);

    public List<Roles> listUserRole();

    public void removeUserRole(int id);

    public Roles getUserRole(int id);

    public Roles findRoleByName(String roles);


}
