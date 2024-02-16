package model;

import javax.persistence.*;

@Entity
@Table(name="expenses")
public class Expense {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="ITEM")
	private String item;
	@Column(name="AMOUNT")
	private double amount;
	@Column(name="FREQUENCY")
	private String frequency;
	
	public Expense() {
		super();
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Expense(String item, double amount, String frequency) {
		super();
		this.item = item;
		this.amount = amount;
		this.frequency = frequency;
	}
	
	public String toString() {
		return this.item + ": $" + this.amount + " " + this.frequency;
	}
	
	
}
