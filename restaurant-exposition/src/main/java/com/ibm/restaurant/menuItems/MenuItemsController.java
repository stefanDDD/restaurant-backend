package com.ibm.restaurant.menuItems;

import com.ibm.restaurant.application.menuItems.MenuItemsService;
import com.ibm.restaurant.domain.menuItems.MenuItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("menu-items")
public class MenuItemsController {

    @Autowired
    private MenuItemsService menuItemsService;

    @Autowired
    private MenuItemsMapperService menuItemsMapperService;

    @PostMapping
    public ResponseEntity<Void> createMenuItems(@RequestBody MenuItemsDTO menuItemsDTO){
        MenuItems menuItems = menuItemsMapperService.mapMenuItemsToDomain(menuItemsDTO);
        menuItemsService.createMenuItems(menuItems);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{menuItemsId}")
    public ResponseEntity<MenuItemsDTO> getMenuItems(@PathVariable Long menuItemsId){
        MenuItems menuItems = menuItemsService.getMenuItems(menuItemsId);
        MenuItemsDTO menuItemsDTO = menuItemsMapperService.mapMenuItemsFromDomain(menuItems);
        return ResponseEntity.status(HttpStatus.OK).body(menuItemsDTO);


    }
}
