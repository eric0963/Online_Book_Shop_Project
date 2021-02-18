package service.impl;

import java.util.List;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import model.Book;
import model.Page;
import service.BookService;

public class BookServiceImpl implements BookService{

	BookDao b=new BookDaoImpl();
	@Override
	public void add(Book book) {
		b.add(book);
		
	}

	@Override
	public void delete(Integer id) {
		b.delete(id);
		
	}

	@Override
	public void update(Book book) {
		b.update(book);
		
	}

	@Override
	public Book queryById(Integer id) {
		return b.queryById(id);
	}

	@Override
	public List<Book> queryBooks() {
		return b.queryBooks();
	}

	@Override
	public Page<Book> page(int pageNo, int pageSize) {
		
		//設置5個page資料
		Page<Book>page=new Page<>();
		
		//2
		page.setPageSize(pageSize);
		
		//透過dao從資料庫取得總筆數
		Integer pageTotalCount=b.queryForPageTotalCount();
		//3
		page.setPageTotalCount(pageTotalCount);
		
		Integer pageTotal=pageTotalCount/pageSize;
		if(pageTotalCount%pageSize>0) {
			pageTotal+=1;
		}
		//4
		page.setPageTotal(pageTotal);
		
		//1
		//當前頁面必須要在得到總頁數後才能執行
		//否則報錯
		page.setPageNo(pageNo);
		
		//獲取當前頁數據的開始索引
		int begin=(page.getPageNo()-1)*pageSize;
		//透過dao從資料庫取得當前頁數據
		List<Book>items=b.queryForItems(begin,pageSize);
		//5
		page.setItems(items);
		
		return page;
	}

	@Override
	public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
		//設置5個page資料
		Page<Book>page=new Page<>();
		
		//2
		page.setPageSize(pageSize);
		
		//透過dao從資料庫取得總筆數
		Integer pageTotalCount=b.queryForPageTotalCount();
		//3
		page.setPageTotalCount(pageTotalCount);
		
		Integer pageTotal=pageTotalCount/pageSize;
		if(pageTotalCount%pageSize>0) {
			pageTotal+=1;
		}
		//4
		page.setPageTotal(pageTotal);
		
		//1
		//當前頁面必須要在得到總頁數後才能執行
		//否則報錯
		page.setPageNo(pageNo);
		
		//獲取當前頁數據的開始索引
		int begin=(page.getPageNo()-1)*pageSize;
		//透過dao從資料庫取得當前頁數據
		List<Book> items = b.queryForItemsByPrice(begin, pageSize, min, max);
		//5
		page.setItems(items);
		
		return page;
	}

}
