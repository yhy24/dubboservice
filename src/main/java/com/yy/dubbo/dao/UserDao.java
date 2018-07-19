package com.yy.dubbo.dao;


import com.yy.dubbo.pojo.User;

import java.util.List;

public interface UserDao {

    public List<User> findUser();

    public int updateCodeById(Integer id);

    public User selectById(Integer id);

    public int updateUser(User user);

    public int insertUser(User user);

    public int deleteUser(Integer id);

}
