package com.ibm.restaurant.domain.menuItems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface IMenuItemsRepository {

    MenuItems createMenuItems(final MenuItems menuItems);

    MenuItems getMenuItems(final Long menuItemsId);

    MenuItems updateMenuItems(final MenuItems menuItems);

    void deleteMenuItems(MenuItems menuItems);

    List<MenuItems> findAll(String menuItemDescription, Integer pageNumber, Integer nrOfItems);

}
