package com.ibm.restaurant.application.menuItems;

import com.ibm.restaurant.domain.menuItems.IMenuItemsRepository;
import com.ibm.restaurant.domain.menuItems.MenuItems;
import com.ibm.restaurant.domain.tables.Tables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class MenuItemsService {

    @Autowired
    public IMenuItemsRepository iMenuItemsRepository;


    public MenuItems createMenuItems(MenuItems menuItems) throws Exception {
        return Optional.ofNullable(iMenuItemsRepository.createMenuItems(menuItems)).orElseThrow(() -> new Exception("Unable to create menu item"));
    }
    public MenuItems getMenuItems(Long menuItemsId) {
        return iMenuItemsRepository.getMenuItems(menuItemsId);
    }



    public MenuItems updateMenuItems(MenuItems menuItems) {
        MenuItems menuItemsFromDB = getMenuItems(menuItems.getMenuItemId());

        if (menuItemsFromDB != null) {
            menuItemsFromDB.setMenuItemName(menuItems.getMenuItemName());
            menuItemsFromDB.setMenuItemPrice(menuItems.getMenuItemPrice());
            menuItemsFromDB.setMenuItemDescription(menuItems.getMenuItemDescription());
            iMenuItemsRepository.updateMenuItems(menuItemsFromDB);
        }
        return null;
    }

    public void deleteMenuItems(Long menuItemsId) {
        MenuItems menuItemsFromDB = getMenuItems(menuItemsId);
        iMenuItemsRepository.deleteMenuItems(menuItemsFromDB);
    }

    public List<MenuItems> findAll(String menuItemDescription, Integer pageNumber, Integer nrOfItems) {
        if(pageNumber == null) {
            pageNumber = 0;
        }

        if(nrOfItems == null) {
            nrOfItems = 10;
        }

        return iMenuItemsRepository.findAll(menuItemDescription, pageNumber, nrOfItems);
    }


}
