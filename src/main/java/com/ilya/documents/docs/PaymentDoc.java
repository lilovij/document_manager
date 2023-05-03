package com.ilya.documents.docs;

import java.time.LocalDate;

public class PaymentDoc implements Document {

	private final String name = "Платежка";
	private String number;
	private LocalDate date;
	private String user;
	private int totalSum;
	private String employee;

	private String infoForTable;

	private boolean isForDelete = false;

	public PaymentDoc(String number, String user, int totalSum, String employee) {
		this.number = number;
		this.date = LocalDate.now();
		this.user = user;
		this.totalSum = totalSum;
		this.employee = employee;
		this.infoForTable = name + " от " + date + " номер " + number;
	}

	public PaymentDoc(String number, LocalDate date, String user, int totalSum, String employee) {
		this.number = number;
		this.date = date;
		this.user = user;
		this.totalSum = totalSum;
		this.employee = employee;
		this.infoForTable = name + " от " + date + " номер " + number;
	}

	@Override
	public String getDocText() {
		return name + "\nНомер: " + number + "\n" +
				"Дата: " + date.toString() + "\n" +
				"Пользователь: " + user + "\n" +
				"Сумма: " + totalSum + "\n" +
				"Сотрудник: " + employee + "\n";
	}

	@Override
	public String toString() {
		return "Накладная от " + date + " номер " + number;
	}

	public String getName() {
		return name;
	}

	public String getInfoForTable() {
		return infoForTable;
	}

	public void setInfoForTable(String infoForTable) {
		this.infoForTable = infoForTable;
	}

	public boolean getIsForDelete() {
		return isForDelete;
	}

	public void setIsForDelete(boolean forDelete) {
		isForDelete = forDelete;
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

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

}
