package retailapp.model;

//import java.math.BigDecimal;
import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;



@Entity
public class RetailApp implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String date;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	private String name;
	
	public RetailApp() {
		super();
		id = 0l;
	}

	public RetailApp(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	//public RetailApp(String date, String name, double price) {
	//	super();
	//	this.name = name;
	//	this.price = price;
	//	this.date=date;
	//}
	
	//public RetailApp(Long id, String date, String name, double price) {
	//	super();
	//	this.name = name;
	//	this.price = price;
	//	this.date=date;
	//	this.id=id;
	//}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);

	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}


}
