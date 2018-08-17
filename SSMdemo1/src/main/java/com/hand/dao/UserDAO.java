package com.hand.dao;

import com.hand.entity.User;


public interface UserDAO {
    User selectUserById(int id);
}
