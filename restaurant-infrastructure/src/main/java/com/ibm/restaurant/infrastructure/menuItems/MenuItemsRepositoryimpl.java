package com.ibm.restaurant.infrastructure.menuItems;

import com.ibm.restaurant.domain.menuItems.IMenuItemsRepository;
import com.ibm.restaurant.domain.menuItems.MenuItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;

@Repository
public class MenuItemsRepositoryimpl implements IMenuItemsRepository {

    @Autowired
    private IMenuItemsRepositorySdj iMenuItemsRepositorySdj;


    @Override
    public MenuItems createMenuItem(MenuItems menuItems) {
        return iMenuItemsRepositorySdj.save(menuItems);
    }

    @Override
    public MenuItems getMenuItems(Long menuItemsId){
        return iMenuItemsRepositorySdj.findById(menuItemsId).orElse(null);
    }

    @Override
    public HashSet<MenuItems> getMenuItemsList() {
        return new HashSet<>(iMenuItemsRepositorySdj.findAll());
    }

    @Override
    public void updateMenuItems(MenuItems menuItems){
        iMenuItemsRepositorySdj.save(menuItems);
    }

    @Override
    public void deleteMenuItems(MenuItems menuItems){
        iMenuItemsRepositorySdj.delete(menuItems);
    }
/*
    @Override
    public List<MenuItems> findAllByName(String menuItemsName){
        return iMenuItemsRepositorySdj.findAllByNameContains(menuItemsName);
    }
*/

}
