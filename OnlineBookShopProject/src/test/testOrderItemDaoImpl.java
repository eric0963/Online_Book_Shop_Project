package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import dao.OrderItemDao;
import dao.impl.OrderItemDaoImpl;
import model.OrderItem;

class testOrderItemDaoImpl {
	
	OrderItemDao oid=new OrderItemDaoImpl();

	@Test
	void testSaveOrderItem() {
		System.out.println(oid.saveOrderItem(new OrderItem(null, "eric", 5, 500, 500, "1")));
	}

	@Test
	void testQueryOrderItemByOrderId() {
		List<OrderItem> list = oid.queryOrderItemByOrderId("1");
		list.forEach(System.out::println);
	}
	
}
