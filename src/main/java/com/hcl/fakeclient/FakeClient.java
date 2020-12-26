package com.hcl.fakeclient;

import com.hcl.productEntry.entity.ProductEntity;
import com.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FakeClient {
    public static void main(String[] args) {
        Session hibernateSesssion = HibernateUtility.getSessionFactory().openSession();
        Transaction transaction = hibernateSesssion.beginTransaction();

        ProductEntity carStereo = new ProductEntity("Alpine Car Stereo", 599.99, 2300);
        hibernateSesssion.save(carStereo);
        transaction.commit();
        System.out.println("fuck me");
    }
}
