package com.ibm.restaurant.domain.menuItems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface IMenuItemsRepository {

    MenuItems createMenuItems(final MenuItems menuItems);

    MenuItems getMenuItems(final Long menuItemsId);

    List<MenuItems> getMenuItemsList();

    MenuItems updateMenuItems(final MenuItems menuItems);

    void deleteMenuItems(final MenuItems menuItems);

    List<MenuItems> findAll(String description, final Integer pageNumber, Integer nrOfItems);

}
