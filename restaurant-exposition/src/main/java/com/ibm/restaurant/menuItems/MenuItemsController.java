package com.ibm.restaurant.menuItems;

import com.ibm.restaurant.application.menuItems.MenuItemsService;
import com.ibm.restaurant.domain.menuItems.MenuItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RestController
@RequestMapping("/menu-items")
public class MenuItemsController {

    @Autowired
    private MenuItemsService menuItemsService;

    @Autowired
    private MenuItemsMapperService menuItemsMapperService;

    @PostMapping
    public ResponseEntity<Void> createMenuItems(@RequestBody MenuItemsDTO menuItemsDTO){
        Long ordersId = menuItemsDTO.ordersId;
        MenuItems menuItems = menuItemsMapperService.mapMenuItemsToDomain(menuItemsDTO);
        menuItemsService.createMenuItems(menuItems, ordersId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{menuItemsId}")
    public ResponseEntity<MenuItemsDTO> getMenuItems(@PathVariable Long menuItemsId){
        MenuItems menuItems = menuItemsService.getMenuItems(menuItemsId);
        MenuItemsDTO menuItemsDTO = menuItemsMapperService.mapMenuItemsFromDomain(menuItems);
        return ResponseEntity.status(HttpStatus.OK).body(menuItemsDTO);

    }
    @GetMapping()
    public ResponseEntity<HashSet <MenuItemsDTO>> getMenuItemsList(){
        HashSet<MenuItems> menuItemsList = menuItemsService.getMenuItemsList();
        HashSet<MenuItemsDTO> menuItemsDTOList = menuItemsMapperService.mapMenuItemsFromDomainList(menuItemsList);
        return ResponseEntity.status(HttpStatus.OK).body(menuItemsDTOList);
    }

    @PutMapping("/{menuItemsId}")
    public ResponseEntity<Void> updateMenuItems(@PathVariable long menuItemsId, @RequestBody MenuItemsDTO menuItemsDTO){
        MenuItems menuItems = menuItemsMapperService.mapMenuItemsToDomain(menuItemsDTO);
        menuItemsService.updateMenuItems(menuItemsId, menuItems);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @DeleteMapping("/{menuItemsId}")
    public ResponseEntity<Void> deleteMenuItems(@PathVariable Long menuItemsId){
        menuItemsService.deleteMenuItems(menuItemsId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
/*
    @GetMapping("/{menuItemsName}")
    public ResponseEntity<List<MenuItemsDTO>> findAllByName(@PathVariable String menuItemsName){
        List<MenuItemsDTO> menuItemsDTOList = menuItemsService.findAllByName(menuItemsName).stream().map(menuItemsMapperService::mapMenuItemsFromDomain).collect(Collectors.toList());
        return ResponseEntity.ok(menuItemsDTOList);
    }
*/
}
