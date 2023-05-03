package com.ilya.documents.controller;

import com.ilya.documents.docs.ApplicationForPaymentDoc;
import com.ilya.documents.docs.Document;
import com.ilya.documents.docs.DocumentManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ApplicationForPaymentController extends Application {

	@FXML
	public TextField numberFiled, userTextField, partnerTextField, totalSumTextField, currencyTextField, rateTextField, comissionTextField;

	@FXML
	public Button saveButton;

	@FXML
	private TableView<Document> tableView;

	public void setTableView(TableView<Document> tableView) {
		this.tableView = tableView;
	}

	@FXML
	protected void onApplicationForPaymentSaveButtonClick() {
		try {
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
			refreshTable();
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

	protected void refreshTable() {
		DocumentManager documentManager = new DocumentManager();
		ObservableList<Document> documentsData = FXCollections.observableArrayList(documentManager.getAllDocuments());
		tableView.getItems().clear();
		tableView.getItems().addAll(documentsData);
		tableView.refresh();
	}

	@Override
	public void start(Stage stage) {
		stage.setOnCloseRequest(e -> Platform.exit());
	}
}

