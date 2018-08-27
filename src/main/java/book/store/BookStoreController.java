package book.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookStoreController {
	
	@Autowired
	BookStoreService bookStoreService;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> allBooks = bookStoreService.getAllBooks();
		if(allBooks == null || allBooks.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity(allBooks, HttpStatus.OK);
	}
	
	
	@GetMapping("/books/id/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable int bookId) {
		Book book = bookStoreService.getBookById(bookId); 
		if(book == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity(book, HttpStatus.OK); 
	}
	
	@GetMapping("/books/category/{category}")
	public ResponseEntity<Book> getBookByCategory(@PathVariable String category) {
		List<Book> books = bookStoreService.getBookByCategory(category); 
		if(books == null || books.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity(books, HttpStatus.OK); 
	}
	
	@GetMapping("/books/available/category/{category}")
	public ResponseEntity<Book> getAvailableBooksByCategory(@PathVariable String category) {
		List<Book> books = bookStoreService.getAvailableBooksByCategory(category); 
		if(books == null || books.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity(books, HttpStatus.OK); 
	}
	
	@GetMapping("/books/available")
	public ResponseEntity<Book> getAvailableBooks() {
		List<Book> books = bookStoreService.getAvailableBooks(); 
		if(books == null || books.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity(books, HttpStatus.OK); 
	}
	
	
	@DeleteMapping("/books/delete/{bookId}")
	public ResponseEntity<Boolean> deleteBook(@PathVariable int bookId) {
		boolean isDeleted = bookStoreService.deleteBook(bookId); 
		if(isDeleted) {
			return new ResponseEntity(true, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NOT_FOUND);
	}

}
