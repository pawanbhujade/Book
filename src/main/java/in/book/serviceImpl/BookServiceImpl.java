package in.book.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.book.entity.Book;
import in.book.repository.BookRepository;
import in.book.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(Integer id) {
		
		return bookRepository.findById(id).orElseThrow();
	}

	@Override
	public Book addBook(Book book) {
		
		return bookRepository.save(book);
	}

	@Override
	public Book updateBook(Integer id, Book book) {
		
		Optional<Book> optional = bookRepository.findById(id);
		
		if(optional.isPresent())
		{
			Book book2=optional.get();
			
			book2.setTitle(book.getTitle());
			book2.setAuthor(book.getAuthor());
			book2.setGenre(book.getGenre());
			book2.setPublishedDate(book.getPublishedDate());
			book2.setIsbn(book.getIsbn());
			
			return bookRepository.save(book2);
		}
		else {
			
			System.out.println("Book Not Avaible");
			return null;
		}
		
		
	}

	@Override
	public String deleteBook(Integer id) {
		
		 bookRepository.deleteById(id);
		 
		 return "Book has been successfully deleted" + id;
	}
	
	
}
