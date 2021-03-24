package com.webapp.youcode.Test;
import java.sql.SQLException;

import com.webapp.youcode.Dao.UsersDao;
import com.webapp.youcode.DaoImp.UsersDaoImpl;
import com.webapp.youcode.Model.Roles;
import com.webapp.youcode.Model.Users;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Roles roles = new Roles();
        roles.setId(1L);
        UsersDao user = new UsersDaoImpl();

        user.create(new Users("test","test","y@gmail.com","test",roles));
        System.out.println(user);}
}
