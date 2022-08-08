package com.ibm.restaurant.domain.menuItems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface IMenuItemsRepository {

    MenuItems createMenuItem(MenuItems menuItems);

    HashSet<MenuItems> getMenuItemsList();

    MenuItems getMenuItems(Long menuItemsId);

    void updateMenuItems(MenuItems menuItems);

    void deleteMenuItems(MenuItems menuItems);

  // List<MenuItems> findAllByName(String menuItemsName);


}
