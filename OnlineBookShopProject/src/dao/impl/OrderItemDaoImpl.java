package dao.impl;

import java.util.List;

import dao.OrderItemDao;
import model.OrderItem;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao{

	@Override
	public int saveOrderItem(OrderItem oi) {
		String sql="insert into t_order_item(name,count,price,totalPrice,orderId)values(?,?,?,?,?)";
		return update(sql, oi.getName(),oi.getCount(),oi.getPrice(),oi.getTotalPrice(),oi.getOrderId());
	}

	@Override
	public List<OrderItem> queryOrderItemByOrderId(String orderId) {
		String sql="select * from t_order_item where orderId=?";
		return queryForAll(OrderItem.class, sql, orderId);
	}

}
