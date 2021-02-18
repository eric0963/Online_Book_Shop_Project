package service;

import java.util.List;

import model.Cart;
import model.Order;
import model.OrderItem;

public interface OrderService {

	public String createOrder(Cart cart,Integer userId);
	
	public List<Order>showAllOrders();
	
	public void sendOrder(String orderId,Integer status);
	
	public List<OrderItem>showOrderDetail(String orderId);
	
	public List<Order>showMyOrder(Integer userId);
	
	public List<Order>queryOrdersByOrderId(String orderId);
}
