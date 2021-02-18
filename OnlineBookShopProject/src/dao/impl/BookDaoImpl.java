package dao.impl;

import java.util.List;

import dao.BookDao;
import model.Book;

public class BookDaoImpl extends BaseDao implements BookDao{

	@Override
	public int add(Book book) {
		String sql="insert into t_book(name,price,author,sales,stock,img_path) values(?,?,?,?,?,?)";
		return update(sql, book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImg_path());
	}

	@Override
	public int delete(Integer id) {
		String sql="delete from t_book where id=?";
		return update(sql, id);
	}

	@Override
	public int update(Book book) {
		String sql="update t_book set name=?,price=?,author=?,sales=?,stock=?,img_path=? where id=?";
		return update(sql, book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImg_path(),book.getId());
	}

	@Override
	public Book queryById(Integer id) {
		String sql="select * from t_book where id=?";
		return queryForOne(Book.class, sql, id);
	}

	@Override
	public List<Book> queryBooks() {
		String sql="select * from t_book";
		return queryForAll(Book.class, sql);
	}

	@Override
	public Integer queryForPageTotalCount() {
		String sql="select count(*) from t_book";
		 Number count = (Number) queryForSingle(sql);
		return count.intValue();
	}

	@Override
	public List<Book> queryForItems(int begin, int pageSize) {
		String sql="select * from t_book limit ?,?";
		return queryForAll(Book.class, sql,begin,pageSize);
	}

	@Override
	public Integer queryForTotalCountByPrice(int min, int max) {
		String sql="select count(*) from t_book where price between ? and ?";
		Number count = (Number) queryForSingle(sql,min,max);
		return count.intValue();
	}

	@Override
	public List<Book> queryForItemsByPrice(int begin, int size, int min, int max) {
		String sql="select * from t_book where price between ? and ? order by price limit ?,? ";
		return queryForAll(Book.class, sql, min,max,begin,size);
	}

}
