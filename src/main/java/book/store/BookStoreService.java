package book.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookStoreService {
	
	private List<Book> books = createBookList();
	
	private List<Book> createBookList(){
		List<Book> bookList = new ArrayList<>();
		bookList.add(new Book(1, "Java", "abc","Technical",260.0,200));
		bookList.add(new Book(2, "SpringBoot", "pqr","Technical",360.0,100));
		bookList.add(new Book(3, "C", "rrr","Technical",288.0,99));
		bookList.add(new Book(4, "C++", "ppp","Technical",422.0,86));
		bookList.add(new Book(5, "Python", "aaa","Technical",366.0,211));
		bookList.add(new Book(6, "Novel1", "asd","Novel",366.0,211));
		bookList.add(new Book(7, "Novel2", "wer","Novel",366.0,0));
		
		return bookList;
	}
	
	public List<Book> getAllBooks(){
		return books;
	}
	
	
	public Book getBookById(int bookId) {
		Book result = null;
		for(Book book : books) {
			if(book.getBookId() == bookId) {
				result = book;
			}
		}
		return result;
	}
	
	public List<Book> getBookByCategory(String category) {
		List<Book> result = new ArrayList<Book>();
		for(Book book : books) {
			if(book.getCategory().equals(category)) {
				result.add(book);
			}
		}
		return result;
	}
	
	public List<Book> getAvailableBooks() {
		List<Book> result = new ArrayList<Book>();
		for(Book book : books) {
			if(book.getStockAvailable()>0) {
				result.add(book);
			}
		}
		return result;
	}
	
	public List<Book> getAvailableBooksByCategory(String category) {
		List<Book> result = new ArrayList<Book>();
		for(Book book : books) {
			if(book.getStockAvailable()>0 && book.getCategory().equals(category)) {
				result.add(book);
			}
		}
		return result;
	}
	
	
	public boolean deleteBook(int bookId) {
		Book bookToBeDeleted = null;
		for(Book book : books) {
			if(book.getBookId() == bookId) {
				bookToBeDeleted = book;
			}
		}
		if(bookToBeDeleted != null)
		books.remove(bookToBeDeleted);
		
		return bookToBeDeleted!=null;
	}

}
