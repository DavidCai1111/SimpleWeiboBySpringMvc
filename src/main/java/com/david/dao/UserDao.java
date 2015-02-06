package com.david.dao;


import com.david.model.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface UserDao {
    public boolean checkUserInfoInForm(String username,String password);
    public boolean FindTheUser(String username);
    public void AddOneUser(String username,String password);
    public User getByUsername(String username);
    public Collection<GrantedAuthority> loadUserAuthorities(String username);
}
