/**
 */
package util;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import datamodel.SocialMediaOut;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class UtilDB {
   static SessionFactory sessionFactory = null;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory != null) {
         return sessionFactory;
      }
      Configuration configuration = new Configuration().configure();
      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
      sessionFactory = configuration.buildSessionFactory(builder.build());
      return sessionFactory;
   }

   public static List<SocialMediaOut> listPosts() {
      List<SocialMediaOut> resultList = new ArrayList<SocialMediaOut>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;  // each process needs transaction and commit the changes in DB.

      try {
         tx = session.beginTransaction();
         List<?> posts = session.createQuery("FROM SocialMediaOut").list();
         for (Iterator<?> iterator = posts.iterator(); iterator.hasNext();) {
            SocialMediaOut post = (SocialMediaOut) iterator.next();
            resultList.add(post);
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   public static List<SocialMediaOut> listPosts(String keyword) {
      List<SocialMediaOut> resultList = new ArrayList<SocialMediaOut>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         System.out.println((SocialMediaOut)session.get(SocialMediaOut.class, 1)); // use "get" to fetch data
        // Query q = session.createQuery("FROM Employee");
         List<?> posts = session.createQuery("FROM SocialMediaOut").list();
         for (Iterator<?> iterator = posts.iterator(); iterator.hasNext();) {
            SocialMediaOut post = (SocialMediaOut) iterator.next();
            if (post.getName().contains(keyword)) {
               resultList.add(post);
            }
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   public static void createPost(String name, String post, String time) {
      Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();
         session.save(new SocialMediaOut(name, post, time));
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }
}
