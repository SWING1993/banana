package com.banana.controller;

import com.banana.mapper.ItemsMapper;
import com.banana.pojo.Items;
//import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 商品管理
@Controller
public class ItemController  {

    @RequestMapping(value = "/itemlist.action")
    public ModelAndView itemList() throws Exception {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        ItemsMapper mapper = (ItemsMapper) ctx.getBean(ItemsMapper.class);


        List<Items> list = mapper.findAllItems();
        ModelAndView mav = new ModelAndView();
        mav.addObject("itemList",list);
        mav.setViewName("itemList.jsp");
        return mav;
    }

    @RequestMapping(value = "/deletes.action")
    public ModelAndView deleteItems(Integer[] ids) throws Exception {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        ItemsMapper mapper = (ItemsMapper) ctx.getBean(ItemsMapper.class);
        mapper.deleteItemsByIds(ids);


        ModelAndView mav = new ModelAndView();
        mav.setViewName("success.jsp");
        return mav;
    }

    @RequestMapping(value = "/success.action")
    public ModelAndView success() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("success.jsp");
        return mav;
    }




}
