package com.vic.repository;

import com.vic.model.BlogsEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by victor on 14/07/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"})
public class BlogReposityTest {

    @Autowired
    private BlogRepository blogReposity;

    @Test
    public void findByBlogTitle() throws Exception {

        BlogsEntity blogsEntity = new BlogsEntity();
        blogsEntity = blogReposity.findByBlogTitle("title1");
        System.out.println(blogsEntity.getContent());

    }

    @Test
    public void addBlog(){
        BlogsEntity blogsEntity = new BlogsEntity();
        blogsEntity.setTitle("title1");
        blogsEntity.setType("a");
        blogsEntity.setContent("aaaaaaaaaaaaaaaaaaaa");

        blogReposity.saveAndFlush(blogsEntity);
    }

    @Test
    public void findByBlogLimit() throws Exception{
        List<String> blogNames = new ArrayList<>();
        blogNames = blogReposity.findByBlogLimit(0,5);
        for (String name:blogNames) {
            System.out.println(name);
        }
    }

    @Test
    public void deleteByBlogTitle() throws Exception{
        String title = "title1";
        blogReposity.deleteByBlogTitle(title);
    }

}