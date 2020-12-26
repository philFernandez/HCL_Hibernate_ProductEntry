package com.hcl.productEntry.dao;

import java.util.List;
import com.hcl.productEntry.entity.ProductEntity;
import com.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDao implements Dao {

    @Override
    public void saveProduct(ProductEntity product) {
        Transaction transaction = null;
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<?> getAllProducts() {
        Transaction transaction = null;
        List<?> allProducts = null;
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            allProducts = session.createQuery("from ProductEntity").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return allProducts;
    }

}
