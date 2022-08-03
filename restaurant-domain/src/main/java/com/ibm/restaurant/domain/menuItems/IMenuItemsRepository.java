package com.ibm.restaurant.domain.menuItems;

import java.util.HashSet;

public interface IMenuItemsRepository {

    void createMenuItem(MenuItems menuItems);

    HashSet<MenuItems> getMenuItemsList();

    MenuItems getMenuItems(Long menuItemsId);

    void updateMenuItems(MenuItems menuItems);

    void deleteMenuItems(MenuItems menuItems);
}
