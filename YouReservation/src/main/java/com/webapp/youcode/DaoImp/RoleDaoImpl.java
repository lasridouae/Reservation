package com.webapp.youcode.DaoImp;

import com.webapp.youcode.Dao.RoleDao;
import com.webapp.youcode.model.Roles;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addRole(Roles roles) {
        sessionFactory.getCurrentSession().save(roles);
    }

    @Override
    public List<Roles> listUserRole() {
        return sessionFactory.getCurrentSession().createQuery("from Roles order by id").list();
    }

    @Override
    public void removeUserRole(int id) {
        Roles roles = (Roles) sessionFactory.getCurrentSession().load(Roles.class, id);
        if (null != roles) {
            sessionFactory.getCurrentSession().delete(roles);
        }
    }

    @Override
    public Roles getUserRole(int id) {
        return (Roles) sessionFactory.getCurrentSession().get(Roles.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Roles findRoleById(Long idRole) {
        List<Roles> roles = new ArrayList<Roles>();

        roles  = sessionFactory.getCurrentSession().createQuery("from Roles where idRole =?").setParameter(0, idRole)
                .list();

        if (roles.size() > 0) {
            return roles .get(0);
        } else {
            return null;
        }
    }
}
