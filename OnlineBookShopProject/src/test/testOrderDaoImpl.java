package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import model.Order;

class testOrderDaoImpl {
	
	OrderDao od=new OrderDaoImpl();

	@Test
	void testSaveOrder() {
		od.saveOrder(new Order("3", new Date(), 500, 0, 1));
	}

	@Test
	void testQueryOrders() {
		List<Order> list = od.queryOrders();
		list.forEach(System.out::println);
	}

	@Test
	void testChangeOrderStatus() {
		System.out.println(od.changeOrderStatus("1", 2));
	}

	@Test
	void testQueryOrderByUserId() {
		List<Order> list = od.queryOrderByUserId(1);
		list.forEach(System.out::println);
	}
	
	@Test
	void testqueryOrdersByOrderId() {
		List<Order> list = od.queryOrdersByOrderId("16135502242791");
		list.forEach(System.out::println);
	}

}
