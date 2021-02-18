package model;

import java.util.List;

public class Page<T> {

	//固定每頁顯示4筆資料
	public static final Integer PAGE_SIZE=4;
	//當前頁碼
	private Integer pageNo;
	//總頁數
	private Integer pageTotal;
	//當前頁顯示數量
	private Integer pageSize=PAGE_SIZE;
	//總筆數
	private Integer pageTotalCount;
	//當前頁數據
	private List<T>items;
	//設置url
	private String url;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		//設定最大頁及最小頁的範圍
		if(pageNo < 1) {
			pageNo=1;
		}
		if(pageNo > pageTotal) {
			pageNo= pageTotal;
		}
		this.pageNo = pageNo;
	}
	public Integer getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
	}
	public Integer getPageTotalCount() {
		return pageTotalCount;
	}
	public void setPageTotalCount(Integer pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
	public List<T> getItems() {
		return items;
	}
	public void setItems(List<T> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageTotal=" + pageTotal + ", pageSize=" + pageSize + ", pageTotalCount="
				+ pageTotalCount + ", items=" + items + ", url=" + url + "]";
	}


	
	
	
}
