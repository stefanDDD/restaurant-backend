package com.ibm.restaurant.infrastructure.menuItems;

import com.ibm.restaurant.domain.menuItems.MenuItems;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IMenuItemsRepositorySdj extends JpaRepository<MenuItems, Long> {

  //  List<MenuItems> findAllByNameContains(String menuItemsName);
}
