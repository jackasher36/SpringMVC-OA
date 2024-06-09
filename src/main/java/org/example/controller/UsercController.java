package org.example.controller;

import org.example.dao.UserDao;
import org.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author Jackasher
 * @version 1.0
 * @className UsercController
 * @since 1.0
 **/
@Controller
public class UsercController {
    public UsercController() {
        System.out.println("UserController is created !!!!!!!!!!!!!!!!!!!!11111");

    }
    @RequestMapping("/a")
    public String A(){
        return "okay.html";
    }

    @Autowired
    private UserDao userDao;
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String B(Model model){
        List<User> users = userDao.selectAll();
        System.out.println(users);
        model.addAttribute("users",users);
        return "user_list.html";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String C(User user){
        int insert = userDao.insert(new User(user.getId(), user.getUsername(), user.getAge()));
        return "redirect:/user";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable("id") String id, Model model){
        User user = userDao.selectById(id);
        model.addAttribute("user",user);
        return "edit.html";
    }
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String modify(User user){
        System.out.println("这是修改表单提交的数据" + user);
        System.out.println("-------------------------------------------");
        userDao.update(user);
        return "redirect:/user";
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String del(@PathVariable("id") String id){
        userDao.delete(id);
        return "redirect:/user";
    }
    @RequestMapping("/ajax")
    public User ajax(RequestEntity requestEntity){
        System.out.println(requestEntity.getMethod());
        System.out.println("-----------------------");
        System.out.println(requestEntity.getUrl());
        System.out.println("-----------------------");
        System.out.println(requestEntity.getHeaders());
        System.out.println("-----------------------");
        System.out.println(requestEntity.getBody());
        User user = new User("jack", "jack", 21);
        return user;
    }

    @RequestMapping("/ajax/1")
    @ResponseBody
    public String ajaxSend(){
        return "scucessfuul!!!!!!!!!11";
    }



}
