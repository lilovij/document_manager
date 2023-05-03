package com.ilya.documents.controller;

import com.ilya.documents.docs.DocumentManager;
import com.ilya.documents.docs.InvoiceDoc;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InvoiceFormController extends Application {

	@FXML
	public TextField numberFiled, userTextField, totalSumTextField, currencyTextField, rateTextField, productTextField, productQuantityTextFiled;

	@FXML
	public Button saveButton;

	@FXML
	protected void onInvoiceSaveButtonClick() {
		try {
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
			Stage stage = (Stage) saveButton.getScene().getWindow();
			stage.close();
		} catch (Exception wrongFieldsData) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Ошибка");
			alert.setHeaderText("Ошибка создания документа");
			alert.setContentText("Убедитесь, что Вы ввели верные значения в поля.");
			alert.showAndWait().ifPresent(rs -> {
			});
		}
	}

	@Override
	public void start(Stage stage) {
		stage.setOnCloseRequest(e -> Platform.exit());
	}
}