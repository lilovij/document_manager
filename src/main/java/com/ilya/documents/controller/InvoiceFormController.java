package com.ilya.documents.controller;

import com.ilya.documents.docs.DocumentManager;
import com.ilya.documents.docs.InvoiceDoc;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.HibernateException;

import java.io.IOException;


public class InvoiceFormController {

//	private MainFormController mainFormController;
//
//	public InvoiceFormController(MainFormController mainFormController) {
//		System.out.println("ONE");
//		this.mainFormController = mainFormController;
//		System.out.println("TWO");
//	}
//
//	public void refreshTable() {
//		mainFormController.onRefreshButtonClick();
//	}

	@FXML
	public TextField numberFiled, userTextField, totalSumTextField, currencyTextField, rateTextField, productTextField, productQuantityTextFiled;

	@FXML
	public Button saveButton;

	@FXML
	protected void onInvoiceSaveButtonClick() throws IOException, HibernateException {

		InvoiceDoc invoiceDoc = new InvoiceDoc(
				numberFiled.getText(),
				userTextField.getText(),
				Integer.parseInt(totalSumTextField.getText()),
				currencyTextField.getText(),
				Double.parseDouble(rateTextField.getText()),
				productTextField.getText(),
				Integer.parseInt(productQuantityTextFiled.getText())
		);

		DocumentManager documentManager = new DocumentManager();
		documentManager.addDocument(invoiceDoc);

//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ilya/documents/main-form.xml"));
//		MainFormController mainFormController = loader.getController();
//		mainFormController.onRefreshButtonClick();

		Stage stage = (Stage) saveButton.getScene().getWindow();
		stage.close();
	}

}


//	private String number;
//	private LocalDate date;
//	private String user;
//	private int totalSum;
//	private String currency;
//	private double rate;
//	private String product;
//	private int productQuantity;