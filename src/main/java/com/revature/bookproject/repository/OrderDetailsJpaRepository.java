package com.revature.bookproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.bookproject.model.OrderDetails;
public interface OrderDetailsJpaRepository extends JpaRepository<OrderDetails,Integer>{

}
