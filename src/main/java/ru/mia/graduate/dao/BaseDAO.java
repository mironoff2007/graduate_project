package ru.mia.graduate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Repository
public class BaseDAO {

    @Autowired
    private SessionFactory sessionFactory;


    public void saveObject(Object theObject) {
        Session currentSession = sessionFactory.openSession();
        try {
            currentSession.beginTransaction();
            currentSession.saveOrUpdate(theObject);
            currentSession.getTransaction().commit();
        }
       finally {
            currentSession.close();
        }
    }


    public Object getObject(int theId,Class clazz) {
        Object theObject;
        Session currentSession = sessionFactory.openSession();
        try {
            currentSession.beginTransaction();
            theObject =  currentSession.get(clazz, theId);
            currentSession.getTransaction().commit();
        }
        finally {
            currentSession.close();
        }
        return theObject;
    }

   
    public <T> List<T> getAllObjects(String name) {
        Session currentSession = sessionFactory.openSession();
        List<T> objects;
        try {
            currentSession.beginTransaction();
            Query theQuery =
                    currentSession.createQuery("from " + name + " order by id");
            currentSession.getTransaction().commit();
            objects = theQuery.list();
        }
        finally {
            currentSession.close();
        }
        return  objects;
    }


    public void getMaxIdObject() {

    }


    public void deleteObject(int theId,String name) {
        Session currentSession = sessionFactory.openSession();
        try {
            currentSession.beginTransaction();
            Query theQuery =
                    currentSession.createQuery("delete from "+name+" where id=:"+name.toLowerCase()+"Id");
            theQuery.setParameter(name.toLowerCase()+"Id", theId);
            theQuery.executeUpdate();
            currentSession.getTransaction().commit();
        }
        finally {
            currentSession.close();
        }
    }

}
