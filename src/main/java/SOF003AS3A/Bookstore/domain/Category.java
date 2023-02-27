package SOF003AS3A.Bookstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long categoryid;
private String name;
	


public Category() {
	super();
	this.categoryid=0;
	}


public Category(long categoryid, String name) {
	super();
	this.categoryid = categoryid;
	this.name = name;
	
}


public long getCategoryid() {
	return categoryid;
}


public String getName() {
	return name;
}


public void setCategoryid(long categoryid) {
	this.categoryid = categoryid;
}


public void setName(String name) {
	this.name = name;
}


@Override
public String toString() {
	return "Category [categoryid=" + categoryid + ", name=" + name + "]";
}


}