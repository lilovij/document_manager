package com.ilya.documents.docs;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "payment_docs")
public class PaymentDoc implements Document {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "number")
	private String number;
	@Column(name = "date")
	private LocalDate date;
	@Column(name = "user")
	private String user;
	@Column(name = "total_sum")
	private int totalSum;
	@Column(name = "employee")
	private String employee;

	private String infoForTable;

	private boolean isForDelete = false;

	public PaymentDoc(String number, String user, int totalSum, String employee) {
		this.number = number;
		this.date = LocalDate.now();
		this.user = user;
		this.totalSum = totalSum;
		this.employee = employee;
		this.infoForTable = "Накладная от " + date + " номер " + number;
	}

	@Override
	public String toString() {
		return "Накладная от " + date + " номер " + number;
	}

	public String getInfoForTable() {
		return infoForTable;
	}

	public void setInfoForTable(String infoForTable) {
		this.infoForTable = infoForTable;
	}

	public boolean getIs() {
		return isForDelete;
	}

	public void setIs(boolean forDelete) {
		isForDelete = forDelete;
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

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

}
