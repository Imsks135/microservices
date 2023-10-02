package com.cgi.order.service;

import java.util.List;
import com.cgi.order.model.Order;

public interface OrderService {

	public List<Order> getAllOrder();

	public Order addOrder(Order order);

}
