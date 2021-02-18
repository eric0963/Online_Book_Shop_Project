package dao;

import java.util.List;

import model.Book;

public interface BookDao {
	
	public int add(Book book);
	
	public int delete(Integer id);
	
	public int update(Book book);
	
	public Book queryById(Integer id);
	
	public List<Book> queryBooks();
	
	public Integer queryForPageTotalCount();

	public List<Book> queryForItems(int begin, int pageSize);
	
	public Integer  queryForTotalCountByPrice(int min,int max);
	
	public List<Book> queryForItemsByPrice(int begin,int size,int min,int max);

}
