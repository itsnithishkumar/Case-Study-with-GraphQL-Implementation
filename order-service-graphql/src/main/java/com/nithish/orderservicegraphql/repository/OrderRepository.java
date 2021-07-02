package com.nithish.orderservicegraphql.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.nithish.orderservicegraphql.entity.Order;


public interface OrderRepository extends MongoRepository<Order, String> {

	List<Order> findByOrderId(String orderId);

	

}
