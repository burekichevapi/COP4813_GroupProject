/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.criterion.Restrictions;

public class HibernateHelper
{
    static protected List<Class> _listOfClasses = new ArrayList<Class>();
    static protected SessionFactory _sessionFactory;

    static public void initSessionFactory(Class... mappings) //hibernate uses this to maintain 
    {                                                                          //its own session separate from TomCat
        if (addMappings(_listOfClasses, mappings)) {
            closeSessionFactory(_sessionFactory);
            _sessionFactory = createFactory(_listOfClasses);
        }
    }

    static public void createTable(Class... mappings)
    {
        List<Class> tempList = new ArrayList<Class>();

        addMappings(tempList, mappings);
        
        Properties props = new Properties();
        
        props.setProperty(Environment.HBM2DDL_AUTO, "create");
        
        SessionFactory tempFactory = createFactory(tempList);
        
        closeSessionFactory(tempFactory);
    }

    static protected boolean addMappings(List<Class> list, Class... mappings)
    {   //This method is doing 2 very different thigns, needs to be split up
        boolean isNewClass = false;
        
        for (Class mapping : mappings) {
            if (!list.contains(mapping)) {
                list.add(mapping);
                isNewClass = true;
            }
        }
        
        return isNewClass;
    }

    static protected SessionFactory createFactory(List<Class> list)
    {
        SessionFactory factory = null;
        Configuration cfg = new Configuration();
        
        try 
        {
            configureFromFile(cfg);
            for (Class mapping : list)
                cfg.addAnnotatedClass(mapping);
            
            factory = buildFactory(cfg);
        }
        catch (Exception ex) 
        {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("SessionFactory creation failed.\n" + ex);
            closeSessionFactory(factory);
            factory = null;
            //hibernate has a runtime exception for handling problems with
            //initialisation. Cast the ex to HibernateException and raise,
            //since the root problem is a HibernateHelper problem.
            throw new HibernateException(ex);
        }
        return factory;
    }

    static protected void configureFromFile(Configuration cfg)
    {
        try 
        {
            cfg.configure();
        }
        catch (HibernateException ex) {
            if (ex.getMessage().equals("/hibernate.cfg.xml not found")) 
                System.err.println("Warning:\n" + ex.getMessage());
            else
            {
                System.err.println("Error in hibernate configuration file:" + ex);
                throw ex;
            }
        }
    }

    static protected SessionFactory buildFactory(Configuration cfg)
            throws Exception
    {
        SessionFactory factory = null;
        try 
        {
            factory = cfg.buildSessionFactory();
        }
        catch (Exception ex) 
        {
            closeSessionFactory(factory);
            factory = null;
            throw ex;
        }
        
        return factory;
    }

    static public void closeSessionFactory(SessionFactory factory)
    {
        if (factory != null)
            factory.close();
    }

    static public void closeFactory() //Should be called when all servlets close.
    {                                 //When the web app is closed.
        //First, servlets will close, then hibernate
        closeSessionFactory(_sessionFactory);
    }

    static public void updateDB(Object obj)
    {
        Session session = null;
        
        try 
        {
            session = _sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            session.saveOrUpdate(obj);

            tx.commit();
        } 
        finally 
        {
            if (session != null)
                session.close();
        }
    }

    static public void updateDB(java.util.List list)
    {

        Session session = null;
        
        try 
        {
            session = _sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            for (Object obj : list)
                session.saveOrUpdate(obj);

            tx.commit();
        } 
        finally 
        {
            if (session != null)
                session.close();
        }
    }

    static public void saveDB(Object obj)
    {
        Session session = null;
        
        try 
        {
            session = _sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            session.save(obj);

            tx.commit();
        }
        finally 
        {
            if (session != null)
                session.close();
        }
    }

    static public void removeDB(Object obj)
    {
        Session session = null;
        try {
            session = _sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            session.delete(obj);

            tx.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    static public java.util.List getListData(Class classBean, String strKey,
            Object value)
    {
        java.util.List result = new java.util.ArrayList();

        Session session = null;
        try {
            session = _sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            Criteria criteria
                    = session.createCriteria(classBean);
            if (strKey != null) {
                criteria.add(Restrictions.like(strKey, value));
            }
            result = criteria.list();

            tx.commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    static public java.util.List getListData(
            Class classBean,
            String strKey1, Object value1,
            String strKey2, Object value2)
    {
        java.util.List result = new java.util.ArrayList();
        boolean withParent = false;
        int age = 0;
        Session session = null;
        try {
            session = _sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            Criteria criteria
                    = session.createCriteria(classBean);
            if (strKey1 != null) {
                criteria.add(Restrictions.like(strKey1, value1));
            }
            if (strKey2 != null) {
                criteria.add(Restrictions.like(strKey2, value2));
            }

            result = criteria.list();

            tx.commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    static public java.util.List getListData(
            Class classBean)
    {
        return getListData(classBean, null, null);
    }

    static public Object getFirstMatch(
            Class classBean, String strKey, Object value)
    {

        Object result = null;
        Session session = null;
        try {
            session = _sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            Criteria criteria
                    = session.createCriteria(classBean);
            if (strKey != null) {
                criteria.add(Restrictions.like(strKey, value));
            }
            criteria.setMaxResults(1);
            result = criteria.uniqueResult();

            tx.commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    static public Object getFirstMatch(
            Object data, String strKey, Object value)
    {
        return getFirstMatch(data.getClass(),
                strKey, value);
    }

    static public Object getKeyData(Class beanClass, long itemId)
    {
        Object data = null;
        Session session = _sessionFactory.openSession();

        data = session.get(beanClass, itemId);

        session.close();

        return data;
    }

    static public boolean isSessionOpen()
    {
        return _sessionFactory != null;
    }
}
