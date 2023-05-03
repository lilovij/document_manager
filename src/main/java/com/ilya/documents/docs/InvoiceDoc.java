package com.ilya.documents.docs;

import javafx.scene.control.CheckBox;

import java.time.LocalDate;

public class InvoiceDoc implements Document {

	private final String name = "Накладная";
	private String number;
	private LocalDate date;
	private String user;
	private int totalSum;
	private String currency;
	private double rate;
	private String product;
	private int productQuantity;
	private String infoForTable;
	private CheckBox isForDelete;

	public InvoiceDoc(String number, String user, int totalSum, String currency, double rate, String product, int productQuantity) {
		this.number = number;
		this.date = LocalDate.now();
		this.user = user;
		this.totalSum = totalSum;
		this.currency = currency;
		this.rate = rate;
		this.product = product;
		this.productQuantity = productQuantity;
		this.infoForTable = name + " от " + date + " номер " + number;
		this.isForDelete = new CheckBox();
		isForDelete.setSelected(false);
	}
	public InvoiceDoc(String number, LocalDate date, String user, int totalSum, String currency, double rate, String product, int productQuantity) {
		this.number = number;
		this.date = date;
		this.user = user;
		this.totalSum = totalSum;
		this.currency = currency;
		this.rate = rate;
		this.product = product;
		this.productQuantity = productQuantity;
		this.infoForTable = name + " от " + date + " номер " + number;
		this.isForDelete = new CheckBox();
		isForDelete.setSelected(true);
	}

	@Override
	public String getDocText() {
		return name + "\nНомер: " + number + "\n" +
				"Дата: " + date.toString() + "\n" +
				"Пользователь: " + user + "\n" +
				"Сумма: " + totalSum + "\n" +
				"Валюта: " + currency + "\n" +
				"Курс: " + rate + "\n" +
				"Продукт: " + product + "\n" +
				"Количество продукции: " + productQuantity + "\n";
	}

	public boolean toDelete() {
		return isForDelete.isSelected();
	}

	@Override
	public CheckBox getIsForDelete() {
		return isForDelete;
	}

	@Override
	public String toString() {
		return "InvoiceDoc{" +
				", number='" + number + '\'' +
				", date=" + date +
				", user='" + user + '\'' +
				", totalSum=" + totalSum +
				", currency='" + currency + '\'' +
				", rate=" + rate +
				", product='" + product + '\'' +
				", productQuantity=" + productQuantity +
				", infoForTable='" + infoForTable + '\'' +
				'}';
	}

	public String getName() {
		return name;
	}


	public void setForDelete(boolean forDelete) {
	}

	public String getInfoForTable() {
		return infoForTable;
	}

	public void setInfoForTable(String infoForTable) {
		this.infoForTable = infoForTable;
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
