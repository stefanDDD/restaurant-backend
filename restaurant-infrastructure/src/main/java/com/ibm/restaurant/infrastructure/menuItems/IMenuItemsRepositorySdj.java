package com.ibm.restaurant.infrastructure.menuItems;

import com.ibm.restaurant.domain.menuItems.MenuItems;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IMenuItemsRepositorySdj extends JpaRepository<MenuItems, Long> {

    List<MenuItems> findByMenuItemNameContainingIgnoreCase(String menuItemName, Pageable page);
    List<MenuItems> findByMenuItemDescriptionContainingIgnoreCase(String menuItemDescription, Pageable page);

}
