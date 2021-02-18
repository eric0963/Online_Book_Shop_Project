package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	
	private Integer totalCount;
	private Integer totalPrice;
	private Map<Integer,CartItem>items=new LinkedHashMap<>();
	
	public Integer getTotalCount() {
		totalCount=0;
		//利用迴圈取得總數量
		for(CartItem value:items.values()){
			totalCount+=value.getCount();
		}
		return totalCount;
	}
	public Integer getTotalPrice() {
		totalPrice=0;
		//利用迴圈取得總金額
		for(CartItem value:items.values()) {
			totalPrice+=value.getTotalPrice();
		}
		return totalPrice;
	}
	public Map<Integer, CartItem> getItems() {
		return items;
	}
	public void setItems(Map<Integer, CartItem> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Cart [totalCount=" + getTotalCount() + ", totalPrice=" + getTotalPrice() + ", items=" + items + "]";
	}
	
	public void addItem(CartItem cartItem) {
		//避免同一商品分2行加入
		//透過map編號確認是否有添加過
		CartItem item=items.get(cartItem.getId());
		//若沒添加過則新增item
		if(item==null) {
			items.put(cartItem.getId(),cartItem);
		}else {
			//若有添加過則數量+1
			item.setCount(item.getCount()+1);
			//並且修改總金額
			item.setTotalPrice(item.getPrice()*item.getCount());
		}
	}
	
	public void delete(Integer id) {
		items.remove(id);
	}
	
	public void clear() {
		items.clear();
	}
	
	public void updateCount(Integer id,Integer count) {
		//先確認購物車內是否有該商品
		CartItem item=items.get(id);
		//若有商品則修改數量及總金額
		if(item!=null) {
			item.setCount(count);
			item.setTotalPrice(item.getCount()*item.getPrice());
		}
	}
	
	

}
