package com.webapp.youcode.DaoImp;
import com.webapp.youcode.Dao.UsersDao;
import com.webapp.youcode.model.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UsersDaoImpl implements UsersDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addUser(Users users) {
        sessionFactory.getCurrentSession().save(users);

    }

    @Override
    public List<Users> listUser() {
        return sessionFactory.getCurrentSession().createQuery("from Users order by id").list();
    }

    @Override
    public void removeUser(int id) {
        Users users = (Users) sessionFactory.getCurrentSession().load(Users.class, id);
        if (null != users) {
            sessionFactory.getCurrentSession().delete(users);
        }

    }

    @Override
    public Users getUser(int id) {
        return (Users) sessionFactory.getCurrentSession().get(Users.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void editUser(Users users) {
        sessionFactory.getCurrentSession().update(users);
    }

    @Override
    public Users findByemail(String email) {
        List<Users> users = new ArrayList<Users>();

        users = sessionFactory.getCurrentSession().createQuery("from Users where email=?").setParameter(0, email).list();

        if (users.size() > 0) {

            return users.get(0);
        } else {

            return null;
        }
    }


}
