package com.myfirstspringproject.myfirstspringproject.dao;

import com.myfirstspringproject.myfirstspringproject.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImp implements RoleDao{
    @Autowired
    private EntityManager entityManager;

    // constructor injection for entityManager
    public RoleDaoImp(EntityManager theEntityManager){
       entityManager =  theEntityManager;
    }
    @Override
    public Role findRoleByName(String theRoleName) {
        // use Entity names instead of table names for this queries
        TypedQuery<Role> theQuery = entityManager.createQuery("FROM Role WHERE name=:roleName", Role.class);
        theQuery.setParameter("roleName",theRoleName);
        Role theRole = null;
        try{
            theRole = theQuery.getSingleResult();
        }catch (Exception e) {
            theRole = null;
        }
        return theRole;
    }

}
