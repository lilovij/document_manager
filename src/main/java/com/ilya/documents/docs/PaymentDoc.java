package com.ilya.documents.docs;

import javafx.scene.control.CheckBox;

import java.time.LocalDate;

public class PaymentDoc implements Document {

	private final String name = "Платежка";
	private String number;
	private LocalDate date;
	private String user;
	private int totalSum;
	private String employee;
	private String infoForTable;
	private CheckBox isForDelete;


	public PaymentDoc(String number, String user, int totalSum, String employee) {
		this.number = number;
		this.date = LocalDate.now();
		this.user = user;
		this.totalSum = totalSum;
		this.employee = employee;
		this.infoForTable = name + " от " + date + " номер " + number;
		this.isForDelete = new CheckBox();
		isForDelete.setSelected(false);
	}

	public PaymentDoc(String number, LocalDate date, String user, int totalSum, String employee) {
		this.number = number;
		this.date = date;
		this.user = user;
		this.totalSum = totalSum;
		this.employee = employee;
		this.infoForTable = name + " от " + date + " номер " + number;
		this.isForDelete = new CheckBox();
		isForDelete.setSelected(false);
	}

	@Override
	public String getDocText() {
		return name + "\nНомер: " + number + "\n" +
				"Дата: " + date.toString() + "\n" +
				"Пользователь: " + user + "\n" +
				"Сумма: " + totalSum + "\n" +
				"Сотрудник: " + employee + "\n";
	}

	public boolean toDelete() {
		return isForDelete.isSelected();
	}

	@Override
	public CheckBox getIsForDelete() {
		return isForDelete;
	}

	public void setIsForDelete(CheckBox isForDelete) {
		this.isForDelete = isForDelete;
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
