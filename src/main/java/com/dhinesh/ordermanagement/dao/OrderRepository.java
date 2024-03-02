package com.dhinesh.ordermanagement.dao;

import com.dhinesh.ordermanagement.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {

}
