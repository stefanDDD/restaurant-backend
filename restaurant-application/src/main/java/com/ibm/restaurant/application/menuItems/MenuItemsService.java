package com.ibm.restaurant.application.menuItems;

import com.ibm.restaurant.domain.menuItems.IMenuItemsRepository;
import com.ibm.restaurant.domain.menuItems.MenuItems;
import com.ibm.restaurant.domain.orders.IOrdersRepository;
import com.ibm.restaurant.domain.orders.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class MenuItemsService {

    @Autowired
    public IMenuItemsRepository iMenuItemsRepository;
    @Autowired
    private IOrdersRepository iOrdersRepository;


    public void createMenuItems(MenuItems menuItems, Long ordersId){
        Orders orders = iOrdersRepository.getOrdersById(ordersId);
        menuItems.setOrders(orders);
        iMenuItemsRepository.createMenuItem(menuItems);
    }

    public MenuItems getMenuItems(Long menuItemsId){
        return iMenuItemsRepository.getMenuItems(menuItemsId);
    }

    public HashSet<MenuItems> getMenuItemsList(){
        return iMenuItemsRepository.getMenuItemsList();
    }

    public void updateMenuItems(Long menuItemsId, MenuItems menuItems){
        MenuItems menuItemsFromDB = getMenuItems(menuItemsId);
        menuItemsFromDB.setMenuItemName(menuItems.getMenuItemName());
        menuItemsFromDB.setMenuItemPrice(menuItems.getMenuItemPrice());
        menuItemsFromDB.setMenuItemDescription(menuItems.getMenuItemDescription());
        iMenuItemsRepository.updateMenuItems(menuItemsFromDB);
    }

    public void deleteMenuItems(Long menuItemsId){
        MenuItems menuItemsFromDB = getMenuItems(menuItemsId);
        iMenuItemsRepository.deleteMenuItems(menuItemsFromDB);
    }
/*
    public List<MenuItems> findAllByName(String menuItemsName){
        return iMenuItemsRepository.findAllByName(menuItemsName);
    }
*/
}
