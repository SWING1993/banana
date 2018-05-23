package com.banana.test;

import com.banana.mapper.ItemsMapper;
import com.banana.pojo.Items;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class JunitTest {

    @Test
    public void itemList() throws Exception {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        ItemsMapper mapper = (ItemsMapper) ctx.getBean(ItemsMapper.class);


        List<Items> list = mapper.findAllItems();
        System.out.println(list);

    }
}
