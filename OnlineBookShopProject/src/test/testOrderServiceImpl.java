package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.Cart;
import model.CartItem;
import model.Order;
import model.OrderItem;
import service.OrderService;
import service.impl.OrderServiceImpl;

class testOrderServiceImpl {
	
	OrderService os=new OrderServiceImpl();

	@Test
	void testCreateOrder() {
		
		Cart cart=new Cart();
		cart.addItem(new CartItem(1, "eric", 5, 500, 500));
		cart.addItem(new CartItem(2, "terry", 5, 600, 600));
		cart.addItem(new CartItem(3, "chou", 5, 700, 700));
		System.out.println(os.createOrder(cart, 1));
	}

	@Test
	void testShowAllOrders() {
		List<Order> list = os.showAllOrders();
		list.forEach(System.out::println);
	}

	@Test
	void testSendOrder() {
		os.sendOrder("3", 3);
	}

	@Test
	void testShowOrderDetail() {
		List<OrderItem> list = os.showOrderDetail("16136307308281");
		list.forEach(System.out::println);
	}

	@Test
	void testShowMyOrder() {
		List<Order> list = os.showMyOrder(1);
		list.forEach(System.out::println);
	}
	
	@Test
	void testQueryOrdersByOrderId() {
		List<Order> list = os.queryOrdersByOrderId("16136307308281");
		list.forEach(System.out::println);
	}

}
