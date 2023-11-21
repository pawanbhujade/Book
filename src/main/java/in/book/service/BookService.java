package in.book.service;

import java.util.List;
import java.util.Optional;

import in.book.entity.Book;

public interface BookService {
	
	
	List<Book> getAllBooks();
    public Book getBookById(Integer id);
    public Book addBook(Book book);
    public Book updateBook(Integer id, Book book);
    public String deleteBook(Integer id);

}
