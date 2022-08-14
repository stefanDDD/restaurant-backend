package com.ibm.restaurant.infrastructure.menuItems;

import com.ibm.restaurant.domain.menuItems.IMenuItemsRepository;
import com.ibm.restaurant.domain.menuItems.MenuItems;
import com.ibm.restaurant.domain.orders.Orders;
import com.ibm.restaurant.domain.tables.Tables;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MenuItemsRepositoryImpl implements IMenuItemsRepository {

    @Autowired
    private IMenuItemsRepositorySdj iMenuItemsRepositorySdj;

    @Override
    public MenuItems createMenuItems(MenuItems menuItems) {
        return iMenuItemsRepositorySdj.save(menuItems);
    }

    @Override
    public MenuItems getMenuItems(Long menuItemsId){
        return iMenuItemsRepositorySdj.findById(menuItemsId).orElse(null);
    }
    @Override
    public MenuItems updateMenuItems(MenuItems menuItems){
        return iMenuItemsRepositorySdj.save(menuItems);
    }

    @Override
    public void deleteMenuItems(MenuItems menuItems){
        iMenuItemsRepositorySdj.delete(menuItems);
    }


    @Override
    public List<MenuItems> findAll(String menuItemDescription, Integer pageNumber, Integer nrOfItems) {
        Pageable request = PageRequest.of(pageNumber, nrOfItems);

        if (StringUtils.isEmpty(menuItemDescription)) {
            return Optional.ofNullable(iMenuItemsRepositorySdj.findAll(request)).map(result -> result.getContent()).orElse(Collections.emptyList());
        } else {
            List<MenuItems> filteredByName = iMenuItemsRepositorySdj.findByMenuItemNameContainingIgnoreCase(menuItemDescription, request);

            if (!filteredByName.isEmpty()) {
                return filteredByName;
            } else {
                return iMenuItemsRepositorySdj.findByMenuItemDescriptionContainingIgnoreCase(menuItemDescription, request);
            }
        }
    }



}
