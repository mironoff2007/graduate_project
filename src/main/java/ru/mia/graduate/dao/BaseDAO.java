package ru.mia.graduate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mia.graduate.MainController;

import java.util.List;


@Transactional
@Repository
public class BaseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private MainController controller;

    
    public void saveObject(Object theObject) {
        Session currentSession = sessionFactory.openSession();
        currentSession.beginTransaction();
        currentSession.saveOrUpdate(theObject);
        currentSession.getTransaction().commit();
        currentSession.close();
    }


    public Object getObject(int theId) {
        Object theObject;
        Session currentSession = sessionFactory.openSession();
        try {
            currentSession.beginTransaction();
            theObject =  currentSession.get(Object.class, theId);
            currentSession.getTransaction().commit();
        }
        finally {
            currentSession.close();
        }
        return theObject;
    }

   
    public List<Object> getAllObjects(String name) {
        Session currentSession = sessionFactory.openSession();
        currentSession.beginTransaction();
        Query theQuery =
                currentSession.createQuery("from "+name+" order by id");
        currentSession.getTransaction().commit();
        List<Object> objects = theQuery.list();
        currentSession.close();
        return  objects;
    }


    public void getMaxIdObject() {

    }


    public void deleteObject(int theId,String name) {
        Session currentSession = sessionFactory.openSession();
        try {
            currentSession.beginTransaction();
            Query theQuery =
                    currentSession.createQuery("delete from "+name+" where id=:reastarauntId");
            theQuery.setParameter(name.toLowerCase()+"Id", theId);
            theQuery.executeUpdate();
            currentSession.getTransaction().commit();
        }
        finally {
            currentSession.close();
        }
    }

}
