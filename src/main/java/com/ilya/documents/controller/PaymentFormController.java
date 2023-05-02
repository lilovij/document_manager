package com.ilya.documents.controller;

import com.ilya.documents.docs.DocumentManager;
import com.ilya.documents.docs.PaymentDoc;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PaymentFormController {

	@FXML
	public GridPane gridPane;

	@FXML
	public TextField numberFiled, userTextField, totalSumTextField, employeeTextField;

	@FXML
	public Button saveButton;

	@FXML
	protected void onPaymentSaveButtonClick() {
		PaymentDoc paymentDoc = new PaymentDoc(
				numberFiled.getText(),
				userTextField.getText(),
				Integer.parseInt(totalSumTextField.getText()),
				employeeTextField.getText()
		);

		DocumentManager documentManager = new DocumentManager();
		documentManager.addDocument(paymentDoc);


//		gridPane.add(new Text(paymentDoc.toString()), 0, 0);

		Stage stage = (Stage) saveButton.getScene().getWindow();
		stage.close();
	}

}