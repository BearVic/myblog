package com.vic.controller;

import com.vic.model.BlogsEntity;
import com.vic.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by victor on 18/07/2017.
 */

@Controller
public class BlogController {

    @Autowired
    BlogRepository blogRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/getblognum", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getBlogNum() {
        Map<String, Object> modelMap = new HashMap<>();
        int blogNum = blogRepository.findBlogNum();
        modelMap.put("blognum", blogNum);

        return modelMap;
    }

    @RequestMapping(value = "/gettitles", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getTitles(@RequestParam("curpage") int curPage) {
        curPage = (curPage - 1) * 3;
        List<String> titles = blogRepository.findByBlogLimit(curPage, curPage + 3);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int i = 0;
        for (String title : titles) {
            modelMap.put(("title" + Integer.toString(i)), title);
            i += 1;
        }
        System.out.println(modelMap);
        return modelMap;
    }

    @RequestMapping(value = "/getblog", method = RequestMethod.GET)
    public ModelAndView getBlog(@RequestParam("title") String title) {

        BlogsEntity blogsEntity = blogRepository.findByBlogTitle(title);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("blog.jsp");
        mav.addObject("title", title);
        mav.addObject("content", blogsEntity.getContent());

        return mav;
    }

    @RequestMapping(value = "/newblog", method = RequestMethod.GET)
    public String newBlog() {
        return "newblog.html";
    }

    @RequestMapping(value = "/addblog", method = RequestMethod.GET)
    @ResponseBody
    public String addNewBlog(@RequestParam("title") String title,
                             @RequestParam("content") String content) {
        BlogsEntity blogsEntity = new BlogsEntity();
        blogsEntity.setTitle(title);
        blogsEntity.setContent(content);

        blogRepository.saveAndFlush(blogsEntity);
        System.out.println("add new blog succeed!");

        return "redirect:index";
    }

    @RequestMapping(value = "/delblog", method = RequestMethod.GET)
    @ResponseBody
    public String delBlog(@RequestParam("title") String title) {

        blogRepository.deleteByBlogTitle(title);

        return "index";
    }
}
