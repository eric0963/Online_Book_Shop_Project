package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Book;
import model.Page;
import service.BookService;
import service.impl.BookServiceImpl;

class BookServiceImplTest {
	
	BookService b=new BookServiceImpl();

	@Test
	void testAdd() {
		b.add(new Book(null, "chou444", 444, "chou", 444, 444, null));
	}

	@Test
	void testDelete() {
		b.delete(54);
	}

	@Test
	void testUpdate() {
		b.update(new Book(54, "chou555", 555, "555", 555, 555, null));
	}

	@Test
	void testQueryById() {
		System.out.println(b.queryById(54));
	}

	@Test
	void testQueryBooks() {
		System.out.println(b.queryBooks());
	}

	@Test
	void testPage() {
		Page<Book> page = b.page(0, 4);
		System.out.println(page);
	}
	
	@Test
	void testPageByPrice() {
		Page<Book> page = b.pageByPrice(0, 4, 100, 300);
		System.out.println(page);
		
	}

}
