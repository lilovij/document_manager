package com.ilya.documents.controller;

import com.ilya.documents.docs.ApplicationForPaymentDoc;
import com.ilya.documents.docs.DocumentManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ApplicationForPaymentController {

	@FXML
	public TextField numberFiled, userTextField, partnerTextField, totalSumTextField, currencyTextField, rateTextField, comissionTextField;

	@FXML
	public Button saveButton;

	@FXML
	protected void onApplicationForPaymentSaveButtonClick() {
		ApplicationForPaymentDoc applicationForPaymentDoc = new ApplicationForPaymentDoc(
				numberFiled.getText(),
				userTextField.getText(),
				partnerTextField.getText(),
				Integer.parseInt(totalSumTextField.getText()),
				currencyTextField.getText(),
				Double.parseDouble(rateTextField.getText()),
				Double.parseDouble(comissionTextField.getText())
		);

		DocumentManager documentManager = new DocumentManager();
		documentManager.addDocument(applicationForPaymentDoc);

		Stage stage = (Stage) saveButton.getScene().getWindow();
		stage.close();
	}

}

