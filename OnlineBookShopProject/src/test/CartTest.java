package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Cart;
import model.CartItem;

class CartTest {
	
	Cart c=new Cart();

	@Test
	void testAddItem() {
		c.addItem(new CartItem(1, "eric", 1, 500, 500));
		c.addItem(new CartItem(2, "terry", 1, 600, 600));
		c.addItem(new CartItem(3, "chou", 1, 600, 700));
		System.out.println(c);
	}

	@Test
	void testDelete() {
		c.addItem(new CartItem(1, "eric", 1, 500, 500));
		c.addItem(new CartItem(2, "terry", 1, 600, 600));
		c.addItem(new CartItem(3, "chou", 1, 600, 700));
		c.delete(3);
		System.out.println(c);
	}

	@Test
	void testClear() {
		c.addItem(new CartItem(1, "eric", 1, 500, 500));
		c.addItem(new CartItem(2, "terry", 1, 600, 600));
		c.addItem(new CartItem(3, "chou", 1, 600, 700));
		c.clear();
		System.out.println(c);
	}

	@Test
	void testUpdateCount() {
		c.addItem(new CartItem(1, "eric", 1, 500, 500));
		c.addItem(new CartItem(2, "terry", 1, 600, 600));
		c.addItem(new CartItem(3, "chou", 1, 600, 600));		
		c.updateCount(3, 2);
		System.out.println(c);
	}

}
