package com.gfo.gfo.service;

import com.gfo.gfo.Service.IUserService;
import com.gfo.gfo.Service.ex.ServiceException;
import com.gfo.gfo.entity.User;
import com.gfo.gfo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试类
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {

    @Autowired
    private IUserService service;

    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("mybatis");
            user.setPassword("1234");
            user.setGender(1);
            user.setPhone("电话号码");
            user.setEmail("电子邮箱");
            user.setAvatar("头像");
            service.reg(user);
            System.err.println("OK.");
        } catch (ServiceException e) {
            System.err.println(e.getClass().getName());
        }
    }

    @Test
    public void login() {
        try {
            String username = "gfo";
            String password = "1234";
            User user = service.login(username, password);
            System.err.println("OK. " + user);
        } catch (ServiceException e) {
            System.err.println(e.getClass().getName());
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void changePassword() {
        try {
            Integer uid = 24;
            String oldPassword = "1234";
            String newPassword = "8888";
            String username = "密码管理员";
            service.changePassword(uid, oldPassword, newPassword, username);
            System.err.println("OK.");
        } catch (ServiceException e) {
            System.err.println(e.getClass().getName());
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void showInfo() {
        try {
            Integer uid = 24;
            User result = service.showInfo(uid);
            System.err.println("OK. " + result);
        } catch (ServiceException e) {
            System.err.println(e.getClass().getName());
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void changeInfo() {
        try {
            Integer uid = 24;
            String username = "资料管理员";
            User user = new User();
            user.setPhone("13900139999");
            user.setEmail("root@qq.com");
            user.setGender(1);
            service.changeInfo(uid, username, user);
            System.err.println("OK.");
        } catch (ServiceException e) {
            System.err.println(e.getClass().getName());
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void changeAvatar() {
        try {
            Integer uid = 24;
            String avatar = "1234";
            String username = "密码管理员";
            service.changeAvatar(uid, avatar, username);
            System.err.println("OK.");
        } catch (ServiceException e) {
            System.err.println(e.getClass().getName());
            System.err.println(e.getMessage());
        }
    }

}