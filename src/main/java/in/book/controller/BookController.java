package in.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.book.entity.Book;
import in.book.service.BookService;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping 
	public ResponseEntity<Book> addNewBook(@RequestBody Book book)

	{
		Book book2= bookService.addBook(book);
		
		return new ResponseEntity<>(book2, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks()
	{
	List<Book> book=	bookService.getAllBooks();
		
		return new ResponseEntity<List<Book>>(book,HttpStatus.OK);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Integer id)
	{
		Book book= bookService.getBookById(id);
		
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	@PutMapping(value = "{id}") 
	public ResponseEntity<Book> updateBook(@PathVariable Integer id, @RequestBody Book book)
	{
		Book book2 = bookService.updateBook(id, book);
		return new ResponseEntity<Book>(book2, HttpStatus.OK);
	}
	
	@DeleteMapping(value =  "{id}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer id)
	{
		String book = bookService.deleteBook(id);
		
		return new ResponseEntity<String>(book, HttpStatus.OK);
	}
}
