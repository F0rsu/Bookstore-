package SOF003AS3A.Bookstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;
  private String title;
	private String author;
	@Column(name="release_year")
	private int year;
	private String isbn;
	private float price;
	
	
	public Book() {
		super();
		this.id=0;
		this.title = null;
		this.author =null;
		this.year=0;
		this.isbn=null;
		this.price=0;
	}


	
	


	public Book(long id, String title, String author, int year, String isbn, float price) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}






	public String getTitle() {
		return title;
	}


	public String getAuthor() {
		return author;
	}


	public int getYear() {
		return year;
	}


	public String getIsbn() {
		return isbn;
	}


	public float getPrice() {
		return price;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn
				+ ", price=" + price + "]";
	}


	



}


