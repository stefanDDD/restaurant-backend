package com.ibm.restaurant.application.menuItems;

import com.ibm.restaurant.domain.menuItems.IMenuItemsRepository;
import com.ibm.restaurant.domain.menuItems.MenuItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
@Service
public class MenuItemsService {

    @Autowired
    public IMenuItemsRepository iMenuItemsRepository;

    public void createMenuItems(MenuItems menuItems){
        long menuItemsId = getMenuItemsList().size()+1;
        menuItems.setMenuItemId(menuItemsId);
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

}