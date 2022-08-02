package com.ibm.restaurant.application.tables;

import com.ibm.restaurant.domain.ITableRepository;
import com.ibm.restaurant.domain.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class TableService {

    @Autowired
    private ITableRepository iTableRepository;

    public void create(Table table) {
        long id  = getTableList().size() + 1;
        table.setId(id);
        iTableRepository.createTable(table);
    }

    public Table getTableById(Long id){

        return iTableRepository.getTableById(id);

    }

    public HashSet<Table> getTableList()
    {
        return iTableRepository.getTableList();
    }

    public void updateTable(Long id, Table table){
        Table tableFromDB = getTableById(id);
        tableFromDB.setCapacity(table.getCapacity());
        tableFromDB.setStatus(table.getStatus());
        iTableRepository.updateTable(tableFromDB);

    }

    public void deleteTable(Long id){
        Table tableFromDB = getTableById(id);
        iTableRepository.deleteTable(tableFromDB);
    }
}
