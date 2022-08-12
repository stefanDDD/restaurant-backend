package com.ibm.restaurant.menuItems;

import com.ibm.restaurant.domain.menuItems.MenuItems;
import com.ibm.restaurant.domain.tables.Tables;
import com.ibm.restaurant.tables.TableDto;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MenuItemsMapperService {


    public MenuItems mapMenuItemsToDomain(final MenuItemsDTO menuItemsDTO){
        MenuItems menuItems = new MenuItems(menuItemsDTO.menuItemsName, menuItemsDTO.menuItemsPrice, menuItemsDTO.menuItemsDescription);
            menuItems.setMenuItemId(menuItemsDTO.menuItemsId);
            return menuItems;
    }


    public MenuItemsDTO mapMenuItemsFromDomain(MenuItems menuItems){
        if(menuItems != null) {
            MenuItemsDTO menuItemsDTO = new MenuItemsDTO();
            menuItemsDTO.menuItemsName = menuItems.getMenuItemName();
            menuItemsDTO.menuItemsPrice = menuItems.getMenuItemPrice();
            menuItemsDTO.menuItemsDescription = menuItems.getMenuItemDescription();
            menuItemsDTO.menuItemsId = menuItems.getMenuItemId();
            return menuItemsDTO;
        }
        return null;
    }


    public List<MenuItemsDTO> mapFromDomainList(List<MenuItems> menuItems) {
        List<MenuItemsDTO> listAux = new ArrayList<>();
        for (MenuItems menuItems1 : menuItems) {
            listAux.add(mapMenuItemsFromDomain(menuItems1));

        }
        return listAux;
    }

    public List<MenuItemsDTO> mapFromDomainListFindAll(final List<MenuItems> input) {
        if (input != null && !input.isEmpty()) {
            return input.stream()
                    .map(item -> mapMenuItemsFromDomain(item)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }



}
