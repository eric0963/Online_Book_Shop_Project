package dao.impl;

import java.util.List;

import dao.OrderDao;
import model.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao{

	@Override
	public int saveOrder(Order order) {
		String sql="insert into t_order(orderId,createTime,price,status,userId) values(?,?,?,?,?)";
		return update(sql, order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
	}

	@Override
	public List<Order> queryOrders() {
		String sql="select * from t_order";
		return queryForAll(Order.class, sql);
	}

	@Override
	public int changeOrderStatus(String orderId, Integer status) {
		String sql="update t_order set status=? where orderId=?";
		return update(sql, status,orderId);
	}

	@Override
	public List<Order> queryOrderByUserId(Integer userId) {
		String sql="select * from t_order where userId=?";
		return queryForAll(Order.class, sql, userId);
	}

	@Override
	public List<Order> queryOrdersByOrderId(String orderId) {
		String sql="select * from t_order where orderId=?";
		return queryForAll(Order.class, sql, orderId);
	}

}
