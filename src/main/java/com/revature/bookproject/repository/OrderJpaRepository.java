package com.revature.bookproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.revature.bookproject.model.Order;
import com.revature.bookproject.model.User;
@Component
public interface OrderJpaRepository extends JpaRepository<Order,Integer>{
	List<Order> findByUser(User u);
}
