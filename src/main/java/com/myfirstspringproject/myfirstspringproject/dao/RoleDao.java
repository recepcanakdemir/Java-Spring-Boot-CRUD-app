package com.myfirstspringproject.myfirstspringproject.dao;

import com.myfirstspringproject.myfirstspringproject.entity.Role;

public interface RoleDao {
    public Role findRoleByName(String theRoleName);
}
