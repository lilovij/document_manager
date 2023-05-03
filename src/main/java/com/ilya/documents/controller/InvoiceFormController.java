package com.ilya.documents.controller;

import com.ilya.documents.MainApplication;
import com.ilya.documents.docs.Document;
import com.ilya.documents.docs.DocumentManager;
import com.ilya.documents.docs.InvoiceDoc;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class InvoiceFormController extends Application {

	@FXML
	public TextField numberFiled, userTextField, totalSumTextField, currencyTextField, rateTextField, productTextField, productQuantityTextFiled;

	@FXML
	public Button saveButton;

	@FXML
	private TableView<Document> tableView;

	public void setTableView(TableView<Document> tableView) {
		this.tableView = tableView;
	}

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

//			FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-form.fxml"));
//			fxmlLoader.load();
//			MainFormController mainFormController = fxmlLoader.getController();
//			mainFormController.refreshTable();

			refreshTable();



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