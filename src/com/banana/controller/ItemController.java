package com.banana.controller;

import com.banana.pojo.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 商品管理
@Controller
public class ItemController {

    @RequestMapping(value = "/itemlist.action")

    public ModelAndView itemList() {

        List<Items> list = new ArrayList<Items>();
        list.add(new Items(1,"xiaomi",2999.0f,new Date(),"miui"));
        list.add(new Items(2,"iphone",9999.0f,new Date(),"2"));
        list.add(new Items(3,"sony",6999.0f,new Date(),"dads"));
        list.add(new Items(4,"sum",4999.0f,new Date(),"miudadi"));
        list.add(new Items(5,"java",1999.0f,new Date(),"mdaiui"));
        list.add(new Items(6,"swift",999.0f,new Date(),"dad"));

        ModelAndView mav = new ModelAndView();
        mav.addObject("itemList",list);
        mav.setViewName("itemList.jsp");
        return mav;
    }

}
