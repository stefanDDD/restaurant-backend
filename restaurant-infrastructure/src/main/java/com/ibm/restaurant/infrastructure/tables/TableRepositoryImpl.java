package com.ibm.restaurant.infrastructure.tables;

import com.ibm.restaurant.domain.tables.ITableRepository;
import com.ibm.restaurant.domain.tables.Tables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class TableRepositoryImpl implements ITableRepository {

    @Autowired
    private ITableRepositorySdj repositorySdj;

    @Override
    public void createTable(Tables table) {
        repositorySdj.save(table);
    }

    @Override
    public Tables getTableById(Long id) {
        return repositorySdj.findById(id).orElse(null);
    }

    public HashSet<Tables> getTableList() {

        return new HashSet<>(repositorySdj.findAll());
    }

    @Override
    public void updateTable(Tables table) {
        repositorySdj.save(table);
    }

    @Override
    public void deleteTable(Tables table) {
        repositorySdj.delete(table);
    }
}

