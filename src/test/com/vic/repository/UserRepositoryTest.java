package com.vic.repository;

import com.vic.model.UsersEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by victor on 14/07/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"})
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private UsersEntity usersEntity=new UsersEntity();

    @Test
    public void findByUsername() throws Exception {

        usersEntity=userRepository.findByUsername("abc");
        System.out.println(usersEntity.getUsername());

    }

    @Test
//    @Transactional
//    @Rollback
    public void addUser() throws Exception{

        UsersEntity newUser = new UsersEntity();
        newUser.setBlognum(0);
        newUser.setPassword("456");
        newUser.setUsername("def");

        userRepository.saveAndFlush(newUser);
    }

}