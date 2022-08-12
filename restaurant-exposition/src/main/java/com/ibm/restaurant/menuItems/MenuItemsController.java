package com.ibm.restaurant.menuItems;

import com.ibm.restaurant.application.menuItems.MenuItemsService;
import com.ibm.restaurant.domain.menuItems.MenuItems;
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

    @GetMapping
    public ResponseEntity<List<MenuItemsDTO>> getMenuItemsList(){
        List<MenuItems> menuItems = menuItemsService.getMenuItemsList();
        List<MenuItemsDTO> menuItemsDTOS = menuItemsMapperService.mapFromDomainList(menuItems);
        return ResponseEntity.status(HttpStatus.OK).body(menuItemsDTOS);
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
    public ResponseEntity<Void> deleteMenuItems(final Long menuItemsId){
        menuItemsService.deleteMenuItems(menuItemsId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("")
    public ResponseEntity<List<MenuItemsDTO>> findAll(@PathParam("description") final String description, @PathParam("pageNumber") final Integer pageNumber,
                                                     @PathParam("nrOfItems") final Integer nrOfItems) {
        List<MenuItems> items = menuItemsService.findAll(description, pageNumber, nrOfItems);
        return ResponseEntity.status(HttpStatus.OK).body(menuItemsMapperService.mapFromDomainListFindAll(items));
    }

}
