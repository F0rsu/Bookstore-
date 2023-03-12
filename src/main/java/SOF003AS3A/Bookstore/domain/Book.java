package SOF003AS3A.Bookstore.domain;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
	private double price;
	
	@ManyToOne
	 @JsonIgnoreProperties ("books") 
	@JoinColumn(name = "categoryid")  // Foreign key - määritys
	private Category category;
	
	
   public Book()  {}

	
  



	public Book(long id, String title, String author, int year, String isbn, double price, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	    this.category= category;
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


	public double getPrice() {
		return price;
	}


	public Category getCategory() {
		return category;
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


	public void setPrice(double price) {
		this.price = price;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public void setCategory (Category category) {
		this.category= category;
	}

	@Override
	public String toString() {
		if(this.category != null)
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn
				+ ", price=" + price + ", category=" + category + "]";
		else
			return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn
					+ ", price=" + price;
	}


	
	


}


