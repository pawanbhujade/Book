package in.book.entity;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
public class Book {
	

	private Integer bookid;
    private String title;
    private String author;
    private String isbn;
    private String publishedDate;
    private String genre;

}
