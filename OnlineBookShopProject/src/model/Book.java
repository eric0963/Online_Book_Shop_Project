package model;

public class Book {
	
	private Integer id;
	private String name;
	private Integer price;
	private String author;
	private Integer sales,stock;
	private String img_path;
	public Book() {
		super();
	}
	public Book(Integer id, String name, Integer price, String author, Integer sales, Integer stock,String img_path) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.author = author;
		this.sales = sales;
		this.stock = stock;
		if(img_path==null){
			img_path="static/img/book.jpg";
		}
		this.img_path=img_path;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", author=" + author + ", sales=" + sales
				+ ", stock=" + stock + ", img_path=" + img_path + "]";
	}
	
	

}
