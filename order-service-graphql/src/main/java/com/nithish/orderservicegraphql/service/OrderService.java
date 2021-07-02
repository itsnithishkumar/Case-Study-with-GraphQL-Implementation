package com.nithish.orderservicegraphql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.nithish.orderservicegraphql.entity.Order;
import com.nithish.orderservicegraphql.repository.OrderRepository;

@Service
public class OrderService implements GraphQLQueryResolver, GraphQLMutationResolver {
	
	@Autowired
	OrderRepository orderRepository;
	
	public Order placeOrder(Order order){
        
		return orderRepository.save(order);
    }
	
    public List<Order> getOrderByOrderId(String orderId){
        
            List<Order> order = orderRepository.findByOrderId(orderId);
            return  order;   
    }

    public Order updateOrder(Order order){
        
        	orderRepository.save(order);
            return order;    
    }

}
