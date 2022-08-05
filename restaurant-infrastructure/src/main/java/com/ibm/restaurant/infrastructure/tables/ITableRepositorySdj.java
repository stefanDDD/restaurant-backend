package com.ibm.restaurant.infrastructure.tables;

import com.ibm.restaurant.domain.tables.Tables;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITableRepositorySdj extends JpaRepository<Tables, Long> {
}
