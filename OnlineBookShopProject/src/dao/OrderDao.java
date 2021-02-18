package dao;

import java.util.List;

import model.Order;

public interface OrderDao {
	
	public int saveOrder(Order order);
	
	public List<Order>queryOrders();
	
	public List<Order> queryOrdersByOrderId(String orderId);
	
	public int changeOrderStatus(String orderId,Integer status);
	
	public List<Order> queryOrderByUserId(Integer userId);

}
