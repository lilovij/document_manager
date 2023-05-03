package com.ilya.documents.controller;

import com.ilya.documents.docs.DocumentManager;
import com.ilya.documents.docs.PaymentDoc;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PaymentFormController {

	@FXML
	public TextField numberFiled, userTextField, totalSumTextField, employeeTextField;

	@FXML
	public Button saveButton;

	@FXML
	protected void onPaymentSaveButtonClick() {
		try {
			PaymentDoc paymentDoc = new PaymentDoc(
					numberFiled.getText(),
					userTextField.getText(),
					Integer.parseInt(totalSumTextField.getText()),
					employeeTextField.getText()
			);
			DocumentManager documentManager = new DocumentManager();
			documentManager.addDocument(paymentDoc);
			Stage stage = (Stage) saveButton.getScene().getWindow();
			stage.close();
		} catch (Exception wrongFieldsData) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Ошибка");
			alert.setHeaderText("Ошибка создания документа");
			alert.setContentText("Убедитесь, что Вы ввели верные значения в поля.");
			alert.showAndWait().ifPresent(rs -> {});
		}
	}

}