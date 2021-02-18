package service;

import java.util.List;

import model.Book;
import model.Page;

public interface BookService {
	
	public void add(Book book);
	
	public void delete(Integer id);
	
	public void update(Book book);
	
	public Book queryById(Integer id);
	
	public List<Book>queryBooks();
	
	Page<Book> page(int pageNo, int pageSize);
	
	Page<Book>pageByPrice(int pageNo,int pageSize,int min,int max);
}
