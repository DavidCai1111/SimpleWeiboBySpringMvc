package com.david.dao;


public interface UserDao {
    public boolean checkUserInfoInForm(String username,String password);
    public boolean FindTheUser(String username);
    public void AddOneUser(String username,String password);
}
