package com.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

    public static SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}
