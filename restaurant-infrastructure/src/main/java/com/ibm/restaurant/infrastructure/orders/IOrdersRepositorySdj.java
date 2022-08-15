package com.ibm.restaurant.infrastructure.orders;

import com.ibm.restaurant.domain.orders.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IOrdersRepositorySdj extends CrudRepository<Orders,Long> {
}
