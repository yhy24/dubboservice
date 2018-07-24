package com.yy.dubbo.service;

import com.yy.dubbo.pojo.User;

public interface HelloService {
    public String sayHello(String name);

    public String findUser();

    public String updateUser();

    public String createUser();

    public String userDelete(Integer id);
    
    public String selectById(Integer id);
}
