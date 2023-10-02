package com.cgi.order.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cgi.order.model.Order;
import com.cgi.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();

	}

	@Override
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		Order createdOrder = orderRepository.save(order);
		return createdOrder;

	}

}
