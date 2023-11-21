package in.book.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import in.book.entity.Book;
import in.book.repository.BookRepository;
import in.book.serviceImpl.BookServiceImpl;

public class BookServiceImplTest {
	
	@Mock
	private BookRepository bookRepository;
	
	@InjectMocks
	private BookServiceImpl bookServiceImpl;
	    
	    
	    @Test
	    public void test_addNewBook()
	    {
	    	Book book1 = new Book();
			
			book1.setAuthor(null);
			book1.setAuthor("abc");
			book1.setGenre("def");
			book1.setIsbn("jkl");
			book1.setPublishedDate("28/01/2023");
			
			when(bookRepository.save(book1)).thenReturn(book1);
			
			Book result = bookServiceImpl.addBook(book1);
			
			assertEquals(book1, result);
			
			verify(bookRepository).save(book1);
			
	    }
	
	
	
	@Test
	public void test_getAllBooks() {

		List<Book> books = new ArrayList<>();
		Book book1 = new Book();
		book1.setBookid(1);
		book1.setAuthor(null);
		book1.setAuthor("abc");
		book1.setGenre("def");
		book1.setIsbn("jkl");
		book1.setPublishedDate("28/01/2023");

		books.add(book1);

		when(bookRepository.findAll()).thenReturn(books);

		assertEquals(1, bookServiceImpl.getAllBooks().size());

	}

	@Test
	public void test_getBookById()
	{
		Book book = new Book();
		
		book.setBookid(1);
		book.setAuthor(null);
		book.setAuthor("abc");
		book.setGenre("def");
		book.setIsbn("jkl");
		book.setPublishedDate("28/01/2023");
		
		when(bookRepository.findById(1)).thenReturn(Optional.of(book));
		
		Book actualbook = bookServiceImpl.getBookById(1); 
		
		assertEquals(1, actualbook.getBookid());
	}
	
	@Test
	public void deleteBook()
	{
		Integer bookId = 1;
		
		BookRepository bookRepository= mock(BookRepository.class);
		
		doNothing().when(bookRepository).deleteById(bookId);
		
		  String result = bookServiceImpl.deleteBook(bookId);
		  
		  assertEquals("Book has been successfully deleted", bookId,result);
	}
	


	
	
	@Test
	public void test_updateBook() {
		Integer bookid = 1;
        Book book = new Book();
		
		book.setAuthor("xyz");
		book.setAuthor("abc");
		book.setGenre("def");
		book.setIsbn("jkl");
		book.setPublishedDate("28/01/2023");
		
		Optional<Book> optionalbook = Optional.of(book);
		
		Book updatebook = new Book();
		updatebook.setAuthor("abcd");
		updatebook.setAuthor("lmno");
		updatebook.setGenre("pqrrr");
		updatebook.setIsbn("abcd");
		updatebook.setPublishedDate("28/12/2023");
		
		when(bookRepository.findById(bookid)).thenReturn(optionalbook);
		when(bookRepository.save(book)).thenReturn(updatebook);
		Book result = bookServiceImpl.updateBook(bookid, book);
		
		assertEquals(updatebook,result);
		
		verify(bookRepository).save(book);
	}
	
	
}
