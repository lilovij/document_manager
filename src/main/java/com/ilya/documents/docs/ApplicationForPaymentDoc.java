package com.ilya.documents.docs;

import java.time.LocalDate;

public class ApplicationForPaymentDoc implements Document {

	private final String name = "Заявка на оплату";
	private String number;
	private LocalDate date;
	private String user;
	private String partner;
	private int totalSum;
	private String currency;
	private double rate;
	private double commission;
	private String infoForTable;
	private boolean isForDelete = false;

	public ApplicationForPaymentDoc(String number, String user, String partner, int totalSum, String currency, double rate, double commission) {
		this.number = number;
		this.date = LocalDate.now();
		this.user = user;
		this.partner = partner;
		this.totalSum = totalSum;
		this.currency = currency;
		this.rate = rate;
		this.commission = commission;
		this.infoForTable = name + " от " + date + " номер " + number;
	}

	public ApplicationForPaymentDoc(String number, LocalDate date, String user, String partner, int totalSum, String currency, double rate, double commission) {
		this.number = number;
		this.date = date;
		this.user = user;
		this.partner = partner;
		this.totalSum = totalSum;
		this.currency = currency;
		this.rate = rate;
		this.commission = commission;
		this.infoForTable = name + " от " + date + " номер " + number;
	}

	@Override
	public String toString() {
		return "Заявка на оплату от " + date + " номер " + number;
	}

	@Override
	public String getDocText() {
		return name + "\nНомер: " + number + "\n" +
				"Дата: " + date.toString() + "\n" +
				"Пользователь: " + user + "\n" +
				"Партнер: " + partner + "\n" +
				"Сумма: " + totalSum + "\n" +
				"Валюта: " + currency + "\n" +
				"Курс: " + rate + "\n" +
				"Коммиссия: " + commission + "\n";
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean getIsForDelete() {
		return isForDelete;
	}

	@Override
	public void setIsForDelete(boolean forDelete) {
		isForDelete = forDelete;
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

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
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

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

}
