package com.ibm.restaurant.menuItems;

import com.ibm.restaurant.application.menuItems.MenuItemsService;
import com.ibm.restaurant.domain.menuItems.MenuItems;
import com.ibm.restaurant.domain.tables.Tables;
import com.ibm.restaurant.tables.TableDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/menu-items")
public class MenuItemsController {

    @Autowired
    private MenuItemsService menuItemsService;

    @Autowired
    private MenuItemsMapperService menuItemsMapperService;

    @PostMapping
    public ResponseEntity<Void> createMenuItems(@RequestBody final MenuItemsDTO menuItemsDTO){
        MenuItems menuItems = menuItemsMapperService.mapMenuItemsToDomain(menuItemsDTO);
        try{
            menuItemsService.createMenuItems(menuItems);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{menuItemsId}")
    public ResponseEntity<MenuItemsDTO> getMenuItems(@PathVariable final Long menuItemsId){
        MenuItems menuItems = menuItemsService.getMenuItems(menuItemsId);
        MenuItemsDTO menuItemsDTO = menuItemsMapperService.mapMenuItemsFromDomain(menuItems);
        return ResponseEntity.status(HttpStatus.OK).body(menuItemsDTO);

    }
    @PutMapping("/{menuItemsId}")
    public ResponseEntity<MenuItemsDTO> updateMenuItems(@RequestBody MenuItemsDTO menuItemsDTO){
        return Optional.ofNullable(menuItemsMapperService.mapMenuItemsToDomain(menuItemsDTO)).map(menuItemsObj ->{
            MenuItems updateMenuItems = menuItemsService.updateMenuItems(menuItemsObj);
            MenuItemsDTO menuItemsDTO1 = menuItemsMapperService.mapMenuItemsFromDomain(updateMenuItems);
            return ResponseEntity.status(HttpStatus.OK).body(menuItemsDTO1);
        }).orElse(null);

        }


    @DeleteMapping("/{menuItemsId}")
    public ResponseEntity<Void> deleteMenuItems(@PathVariable Long menuItemsId){
        menuItemsService.deleteMenuItems(menuItemsId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("")
    public ResponseEntity<List<MenuItemsDTO>> findAll(@PathParam("menuItemDescription") String menuItemDescription, @PathParam("pageNumber") Integer pageNumber,
                                                     @PathParam("nrOfItems") Integer nrOfItems) {
        List<MenuItems> items = menuItemsService.findAll(menuItemDescription, pageNumber, nrOfItems);
        return ResponseEntity.status(HttpStatus.OK).body(menuItemsMapperService.mapFromDomainListFindAll(items));
    }



}
