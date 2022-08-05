package com.ibm.restaurant.domain.tables;

import java.util.HashSet;

public interface ITableRepository {

    void createTable(Tables table);

    Tables getTableById(Long id);

    HashSet<Tables> getTableList();

    void updateTable(Tables table);

    void deleteTable(Tables table);
}
