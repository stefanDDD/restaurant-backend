package com.ibm.restaurant.infrastructure.tables;

import com.ibm.restaurant.domain.tables.ITableRepository;
import com.ibm.restaurant.domain.tables.Tables;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class TableRepositoryImpl implements ITableRepository {

    private Set<Tables> dbSet = new HashSet<>();

    @Override
    public void createTable(Tables table) {
        dbSet.add(table);
        for (Tables table1 : dbSet) {

            System.out.println("=============== db element: "+ table1.toString());
        }
    }

    @Override
    public Tables getTableById(Long id) {
        List<Tables> tables = new ArrayList<>(dbSet);
        for(Tables table: tables){
            if(id.equals(table.getId())){

                return table;
            }
        }
        return null;
    }

    public HashSet<Tables> getTableList()
    {

        return new HashSet<>(dbSet);
    }

    @Override
    public void updateTable(Tables table) {
        dbSet.remove(table);
        dbSet.add(table);
    }

    @Override
    public void deleteTable(Tables table) {
        dbSet.remove(table);

    }


}
