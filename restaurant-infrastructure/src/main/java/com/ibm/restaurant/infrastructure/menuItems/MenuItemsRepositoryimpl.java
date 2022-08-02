package com.ibm.restaurant.infrastructure.menuItems;

import com.ibm.restaurant.domain.menuItems.IMenuItemsRepository;
import com.ibm.restaurant.domain.menuItems.MenuItems;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class MenuItemsRepositoryimpl implements IMenuItemsRepository {

    private Set<MenuItems> dbMenuItemsSet = new HashSet<>();


    @Override
    public void createMenuItem(MenuItems menuItems) {
        dbMenuItemsSet.add(menuItems);
        for(MenuItems menuItems1: dbMenuItemsSet){
            System.out.println("Menu Item: "+menuItems1.toString());
        }
    }

    @Override
    public MenuItems getMenuItems(Long menuItemsId){
        List<MenuItems> menuItems = new ArrayList<>(dbMenuItemsSet);
        for(MenuItems menuItems1: menuItems){
            if(menuItemsId.equals(menuItems1.getMenuItemId())){
                return menuItems1;
            }
        }
        return null;
    }

    @Override
    public HashSet<MenuItems> getMenuItemsList() {
        return new HashSet<>(dbMenuItemsSet);
    }
}
