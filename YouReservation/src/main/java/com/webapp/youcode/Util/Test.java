package com.webapp.youcode.Util;

import com.webapp.youcode.model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

    public class Test {
        public static void main(String[] args) {
            Users users = new Users();
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction  = null;
            transaction = session.beginTransaction();

            session.save(users);
            transaction.commit();


        }
    }

