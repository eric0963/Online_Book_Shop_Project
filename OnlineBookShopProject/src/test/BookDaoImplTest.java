package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import model.Book;

class BookDaoImplTest {
	
	BookDao b=new BookDaoImpl();

	@Test
	void testAdd() {
		b.add(new Book(null, "chou", 777, "chou", 777, 777, null));
	}

	@Test
	void testDelete() {
		b.delete(52);
	}

	@Test
	void testUpdateBook() {
		b.update(new Book(52, "xxx", 555, "chou", 555, 555, null));
	}

	@Test
	void testQueryById() {
		System.out.println(b.queryById(2));
	}

	@Test
	void testQueryBooks() {
		System.out.println(b.queryBooks());

	}
	
	@Test
	void testQueryForTotalCount() {
		System.out.println(b.queryForPageTotalCount());
	}
	
	@Test
	void testQueryForItems() {
		List<Book> list = b.queryForItems(0, 4);
		list.forEach(System.out::println);
	}
	
	@Test
	void testQueryForTotalCountByPrice() {
		System.out.println(b.queryForTotalCountByPrice(1, 300));
	}
	
	@Test 
	void testQueryForItemsByPrice() {
		List<Book> list = b.queryForItemsByPrice(0, 4, 1, 300);
		list.forEach(System.out::println);
	}
}
