package dao;

import java.util.List;

import model.OrderItem;

public interface OrderItemDao {
	
	public int saveOrderItem(OrderItem oi);
	
	public List<OrderItem>queryOrderItemByOrderId(String orderId);

}
