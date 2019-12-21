package com.ecomm.dao;

import java.util.List;

import com.ecomm.model.Product;
import com.ecomm.model.UserDetail;

public interface UserDAO {
public boolean registerUser(UserDetail user);
public boolean updateUserDetail(UserDetail user);
public UserDetail getUser(String username);
public List<UserDetail> userList();
}
