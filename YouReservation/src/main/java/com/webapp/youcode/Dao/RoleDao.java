package com.webapp.youcode.Dao;

import com.webapp.youcode.model.*;

import java.util.List;

public interface RoleDao {
    public void addRole(Roles roles);

    public List<Roles> listUserRole();

    public void removeUserRole(int id);

    public Roles getUserRole(int id);

    public Roles findRoleById(Long idRole);

}
