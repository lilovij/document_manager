package com.ilya.documents.docs;

import jakarta.persistence.*;
import java.time.LocalDate;

public class InvoiceDoc implements Document {

	private int id;
	private String number;
	private LocalDate date;
	private String user;
	private int totalSum;
	private String currency;
	private double rate;
	private String product;
	private int productQuantity;
	private String infoForTable;
	private boolean is = false;

	public InvoiceDoc(String number, String user, int totalSum, String currency, double rate, String product, int productQuantity) {
		this.number = number;
		this.date = LocalDate.now();
		this.user = user;
		this.totalSum = totalSum;
		this.currency = currency;
		this.rate = rate;
		this.product = product;
		this.productQuantity = productQuantity;
		this.infoForTable = "Платежка от " + date + " номер " + number;
	}

	@Override
	public boolean getIs() {
		return is;
	}

	@Override
	public void setIs(boolean forDelete) {
		is = forDelete;
	}

	public InvoiceDoc() {
	}

	@Override
	public String toString() {
		return "InvoiceDoc{" +
				"id=" + id +
				", number='" + number + '\'' +
				", date=" + date +
				", user='" + user + '\'' +
				", totalSum=" + totalSum +
				", currency='" + currency + '\'' +
				", rate=" + rate +
				", product='" + product + '\'' +
				", productQuantity=" + productQuantity +
				", infoForTable='" + infoForTable + '\'' +
				", is=" + is +
				'}';
	}

	public String getInfoForTable() {
		return infoForTable;
	}

	public void setInfoForTable(String infoForTable) {
		this.infoForTable = infoForTable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(int totalSum) {
		this.totalSum = totalSum;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
}
