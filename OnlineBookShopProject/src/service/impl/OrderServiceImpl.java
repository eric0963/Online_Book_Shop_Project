package service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import dao.BookDao;
import dao.OrderDao;
import dao.OrderItemDao;
import dao.impl.BookDaoImpl;
import dao.impl.OrderDaoImpl;
import dao.impl.OrderItemDaoImpl;
import model.Book;
import model.Cart;
import model.CartItem;
import model.Order;
import model.OrderItem;
import service.OrderService;

public class OrderServiceImpl implements OrderService{
	
	OrderDao od=new OrderDaoImpl();
	OrderItemDao oid=new OrderItemDaoImpl();
	BookDao dao=new BookDaoImpl();

	@Override
	public String createOrder(Cart cart, Integer userId) {
		
		//orderId必須是唯一值，故使用時間戳+userId代替
		String orderId=System.currentTimeMillis()+""+userId;
		Order order=new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
		od.saveOrder(order);
		
		//使用迴圈取得購物車所有資料
		for(Map.Entry<Integer, CartItem>entry:cart.getItems().entrySet()) {
			CartItem value = entry.getValue();
			//將資料個別取出
			OrderItem orderItem=new OrderItem(value.getId(), value.getName(), value.getCount(), value.getPrice(), value.getTotalPrice(), orderId);
			//保存至資料庫
			oid.saveOrderItem(orderItem);
			
			//完成交易後即更新庫存及銷售資訊
			Book book = dao.queryById(value.getId());
			book.setSales(book.getSales()+value.getCount());
			book.setStock(book.getStock()-value.getCount());
			dao.update(book);
		}
		cart.clear();
		return orderId;
	}

	@Override
	public List<Order> showAllOrders() {
		return od.queryOrders();
	}

	@Override
	public void sendOrder(String orderId,Integer status) {
		od.changeOrderStatus(orderId, status);
		
	}

	@Override  
	public List<OrderItem> showOrderDetail(String orderId) {
		return oid.queryOrderItemByOrderId(orderId);
	}

	@Override
	public List<Order> showMyOrder(Integer userId) {
		return od.queryOrderByUserId(userId);
	}

	@Override
	public List<Order> queryOrdersByOrderId(String orderId) {
		return od.queryOrdersByOrderId(orderId);
	}

}
