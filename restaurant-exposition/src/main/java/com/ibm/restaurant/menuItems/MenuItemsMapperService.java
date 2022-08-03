package com.ibm.restaurant.menuItems;

import com.ibm.restaurant.domain.menuItems.MenuItems;
import org.springframework.stereotype.Service;

import java.lang.management.MemoryUsage;
import java.util.HashSet;

@Service
public class MenuItemsMapperService {

    public MenuItems mapMenuItemsToDomain(MenuItemsDTO menuItemsDTO){
        MenuItems menuItems = new MenuItems();
        menuItems.setMenuItemName(menuItemsDTO.menuItemsName);
        menuItems.setMenuItemPrice(menuItemsDTO.menuItemsPrice);
        menuItems.setMenuItemDescription((menuItemsDTO.menuItemsDescription));
        return menuItems;
    }

    public MenuItemsDTO mapMenuItemsFromDomain(MenuItems menuItems){
        MenuItemsDTO menuItemsDTO = new MenuItemsDTO();
        menuItemsDTO.menuItemsName = menuItems.getMenuItemName();
        menuItemsDTO.menuItemsPrice = menuItems.getMenuItemPrice();
        menuItemsDTO.menuItemsDescription = menuItems.getMenuItemDescription();
        menuItemsDTO.menuItemsId = menuItems.getMenuItemId();
        return menuItemsDTO;
    }

    public HashSet<MenuItemsDTO> mapMenuItemsFromDomainList(HashSet<MenuItems> menuItemsList){
        HashSet<MenuItemsDTO> menuItemsAUX = new HashSet<>();
        for(MenuItems menuItems: menuItemsList){
            menuItemsAUX.add(mapMenuItemsFromDomain(menuItems));
        }
        return menuItemsAUX;
    }


}
