package com.cgi.order.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.order.model.Order;
import com.cgi.order.service.OrderService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/orders")
	public ResponseEntity<?> getAllCart(HttpServletRequest request) {
		ResponseEntity<?> entity = null;

		if (request.getAttribute("emailId") != null) {
			String userId = request.getAttribute("emailId").toString();

			try {
				List<Order> cartList = orderService.getAllOrder();
				entity = new ResponseEntity<List<Order>>(cartList, HttpStatus.OK);
			} catch (Exception e) {
				entity = new ResponseEntity<String>("Error..." + e.getMessage(), HttpStatus.CONFLICT);
			}
		} else {
			entity = new ResponseEntity<String>("Error.. User Not LoggedIN", HttpStatus.CONFLICT);

		}
		return entity;
	}

	@PostMapping("/orders")
		public ResponseEntity<?> addCart(@RequestBody Order order) {
			ResponseEntity<?> entity = null;
			try {
				Order createdCart = orderService.addOrder(order);
				if (createdCart != null) {
					entity = new ResponseEntity<Order>(createdCart, HttpStatus.CREATED);
				} else {
					entity = new ResponseEntity<String>("Error...Cart Not added", HttpStatus.CONFLICT);
				}

			} catch (Exception e) {
				entity = new ResponseEntity<String>("Error..." + e.getMessage(), HttpStatus.CONFLICT);
			}

		 return entity;

	}

}
