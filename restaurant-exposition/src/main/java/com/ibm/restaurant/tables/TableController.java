package com.ibm.restaurant.tables;

import com.ibm.restaurant.application.tables.TableService;
import com.ibm.restaurant.domain.tables.Tables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RestController
@RequestMapping("api/v1/tables")
public class TableController {

    @Autowired
    private TableService tableService;
    @Autowired
    private TableMapperService tableMapperService;

    @PostMapping
    public ResponseEntity<Void> createTable(@RequestBody TableDto dto) {
        Tables table = tableMapperService.mapToDomain(dto);
        tableService.create(table);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TableDto> getTableById(@PathVariable Long id){

        Tables table = tableService.getTableById(id);
        TableDto dto = tableMapperService.mapFromDomain(table);
        return ResponseEntity.status(HttpStatus.OK).body(dto);

    }

    @GetMapping
    public ResponseEntity<HashSet <TableDto>> getTableList()
    {

        HashSet<Tables> tableList = tableService.getTableList();
        HashSet<TableDto> tableDtoList = tableMapperService.mapFromDomain(tableList);
        return ResponseEntity.status(HttpStatus.OK).body(tableDtoList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTable(@PathVariable Long id, @RequestBody TableDto dto)
    {
        Tables table=tableMapperService.mapToDomain(dto);
        tableService.updateTable(id,table);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable Long id) {
        tableService.deleteTable(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}