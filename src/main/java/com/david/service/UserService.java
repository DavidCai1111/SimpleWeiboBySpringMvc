package com.david.service;

import com.david.dao.UserDao;
import com.david.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * User相关Service
 */
@Service
public class UserService implements UserDetailsService {
    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = new User();
        Collection<GrantedAuthority> authorities = userDao.loadUserAuthorities(s);
        user = userDao.getByUsername(s);
        user.setAuthorities(authorities);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);
        return user;
    }

    public boolean findTheUser(String username){
        return userDao.FindTheUser(username);
    }

    public void addOneUser(String username,String password){
        userDao.AddOneUser(username,password);
    }

    public boolean checkUserInfoInForm(String username,String password){
        return userDao.checkUserInfoInForm(username,password);
    }
}
