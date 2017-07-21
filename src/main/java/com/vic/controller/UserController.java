package com.vic.controller;

import com.vic.model.UsersEntity;
import com.vic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by victor on 21/07/2017.
 */

@Controller
@SessionAttributes(value = "user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ModelAttribute("user")
    public UsersEntity initUsersEntity() {
        UsersEntity usersEntity = new UsersEntity();
        return usersEntity;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> login(@RequestParam("username") String username,
                                     @RequestParam("password") String password,
                                     HttpSession httpSession,
                                     @ModelAttribute("user") UsersEntity curUser) {
        Map<String, Object> modelMap = new HashMap<>();
        UsersEntity usersEntity = userRepository.findByUsername(username);
        if (usersEntity == null || !password.equals(usersEntity.getPassword())) {
            modelMap.put("islogin", false);
        } else {
            modelMap.put("islogin", true);
            curUser.setUsername(username);
            curUser.setPassword(password);
        }
        return modelMap;
    }

    @RequestMapping(value = "/islogin", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> isLogin(HttpSession httpSession, @ModelAttribute("user") UsersEntity curUser) {
        Map<String, Object> modelMap = new HashMap<>();
        if (curUser != null && curUser.getUsername() != null) {
            modelMap.put("islogin", true);
        } else {
            modelMap.put("islogin", false);
        }
        System.out.println("curUser:" + curUser);
        return modelMap;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public boolean logout(HttpSession httpSession, SessionStatus sessionStatus) {
//        if (httpSession.getAttribute("islogin") != null
//                && httpSession.getAttribute("islogin").equals(true)) {
//            httpSession.setAttribute("islogin", false);
//            modelMap.put("logout", true);
//        } else {
//            modelMap.put("logout", false);
//        }
//        modelMap.put("islogin", false);
        sessionStatus.setComplete();
        return true;
    }
}
