package com.ibm.restaurant.menuItems;

import com.ibm.restaurant.domain.menuItems.MenuItems;
import com.ibm.restaurant.domain.orders.Orders;
import com.ibm.restaurant.orders.OrdersDTO;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class MenuItemsMapperService {


    public MenuItems mapMenuItemsToDomain(MenuItemsDTO menuItemsDTO){
        if(menuItemsDTO != null) {
            MenuItems menuItems = new MenuItems();
            menuItems.setMenuItemName(menuItemsDTO.menuItemsName);
            menuItems.setMenuItemPrice(menuItemsDTO.menuItemsPrice);
            menuItems.setMenuItemDescription((menuItemsDTO.menuItemsDescription));
            return menuItems;
        }
        return null;
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

    public OrdersDTO mapOrdersFromDomain(Orders orders){
        OrdersDTO ordersDTO = new OrdersDTO();
        ordersDTO.ordersId = orders.getOrderId();
        ordersDTO.orderTime = orders.getOrderTime();
        ordersDTO.orderStatus = orders.getOrderStatus();
        return ordersDTO;
    }


    public HashSet<MenuItemsDTO> mapMenuItemsFromDomainList(HashSet<MenuItems> menuItemsList){
        HashSet<MenuItemsDTO> menuItemsAUX = new HashSet<>();
        for(MenuItems menuItems: menuItemsList){
            menuItemsAUX.add(mapMenuItemsFromDomain(menuItems));
        }
        return menuItemsAUX;
    }


}
