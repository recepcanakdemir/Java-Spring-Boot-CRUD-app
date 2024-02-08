package com.myfirstspringproject.myfirstspringproject.dao;

import com.myfirstspringproject.myfirstspringproject.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao{
    private EntityManager entityManager;

    // constructor injection of entity manager
    @Autowired
    public UserDaoImp(EntityManager entityManager){ this.entityManager = entityManager;}

    // implementation of find by username method
    @Override
    public User findByUserName(String theUserName){
        // retrieve/ read from database using username
        TypedQuery<User> theQuery =entityManager.createQuery("FROM User WHERE userName=:uName AND enabled=true", User.class);
        theQuery.setParameter("uName",theUserName);

        User theUser = null;
        try{
            theUser = theQuery.getSingleResult();
        }catch(Exception e){
            theUser = null;
        }
        return theUser;
    }


}
