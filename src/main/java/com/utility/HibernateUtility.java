package com.utility;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

    public static Session getSession() {
        return new Configuration().configure().buildSessionFactory().openSession();
    }
}
