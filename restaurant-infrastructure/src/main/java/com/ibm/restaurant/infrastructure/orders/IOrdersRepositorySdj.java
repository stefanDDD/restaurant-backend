package com.ibm.restaurant.infrastructure.orders;

import com.ibm.restaurant.domain.orders.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdersRepositorySdj extends JpaRepository<Orders,Long> {
}
