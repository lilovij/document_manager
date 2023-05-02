package com.ilya.documents.docs;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "app_for_payment_docs")
public class ApplicationForPaymentDoc implements Document {

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
	@Column(name = "partner")
	private String partner;
	@Column(name = "total_sum")
	private int totalSum;
	@Column(name = "currency")
	private String currency;
	@Column(name = "rate")
	private double rate;
	@Column(name = "commission")
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
		this.infoForTable = "Заявка на оплату от " + date + " номер " + number;
	}

	@Override
	public String toString() {
		return "Заявка на оплату от " + date + " номер " + number;
	}
	public int getId() {
		return id;
	}

	public String getInfoForTable() {
		return infoForTable;
	}

	public void setInfoForTable(String infoForTable) {
		this.infoForTable = infoForTable;
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

	@Override
	public boolean getIs() {
		return false;
	}

	@Override
	public void setIs(boolean forDelete) {

	}
}
