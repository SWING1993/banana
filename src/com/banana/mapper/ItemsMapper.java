package com.banana.mapper;

import com.banana.pojo.Items;

import java.util.List;

public interface ItemsMapper {

    public void insertItems(Items items) throws Exception;

    public void deleteItemsById(int id) throws Exception;

    public Items findItemsById(int id) throws Exception;

    public List<Items> findAllItems() throws Exception;

    public void deleteItemsByIds(Integer[] ids) throws Exception;
}
