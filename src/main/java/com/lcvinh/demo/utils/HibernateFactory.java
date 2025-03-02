package com.lcvinh.demo.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {

    private static SessionFactory sessionFactory = null;

    private HibernateFactory() {

    }

    public static Session getSession() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration().configure("META-INF/persistence.xml");
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory.openSession();
    }
}
