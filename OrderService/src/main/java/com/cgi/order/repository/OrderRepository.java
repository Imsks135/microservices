package com.cgi.order.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.cgi.order.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order,String> {
   
	public  Optional<Order> findByCartName(String orderId);
}
