package book.store;

public class Book {
	
	private int bookId;
	private String name;
	private String author;
	private String category;
	private Double price;
	private int stockAvailable;	
	
	public Book(int bookId, String name, String author, String category, Double price, int stockAvailable) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.author = author;
		this.category = category;
		this.price = price;
		this.stockAvailable = stockAvailable;
	}
	
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getStockAvailable() {
		return stockAvailable;
	}
	public void setStockAvailable(int stockAvailable) {
		this.stockAvailable = stockAvailable;
	}	
	

}
