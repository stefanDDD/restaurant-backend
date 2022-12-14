package com.ibm.restaurant.application.tables;

import com.ibm.restaurant.domain.tables.ITableRepository;
import com.ibm.restaurant.domain.tables.Tables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class TableService {

    @Autowired
    private ITableRepository iTableRepository;

    public void create(Tables table) {
        long id  = getTableList().size() + 1;
        table.setId(id);
        iTableRepository.createTable(table);
    }

    public Tables getTableById(Long id){

        return iTableRepository.getTableById(id);

    }

    public HashSet<Tables> getTableList()
    {
        return iTableRepository.getTableList();
    }

    public void updateTable(Long id, Tables table)
    {
        Tables tableFromDb=getTableById(id);
        tableFromDb.setCapacity(table.getCapacity());
        tableFromDb.setStatus(table.getStatus());
        iTableRepository.updateTable(tableFromDb);
    }

    public void deleteTable(Long id) {
        Tables tableFromDb = getTableById(id);
        iTableRepository.deleteTable(tableFromDb);
    }


}
