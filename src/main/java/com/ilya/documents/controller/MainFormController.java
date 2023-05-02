package com.ilya.documents.controller;

import com.ilya.documents.HelloApplication;
import com.ilya.documents.docs.Document;
import com.ilya.documents.docs.DocumentManager;
import com.ilya.documents.docs.InvoiceDoc;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {

	@FXML
	private TableView<Document> tableView;

	@FXML
	private TableColumn<Document, Boolean> isColumn;

	@FXML
	private TableColumn<Document, String> nameColumn;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		isColumn.setCellValueFactory(new PropertyValueFactory<>("is"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("infoForTable"));
		nameColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(1.0));
		InvoiceDoc invoice1 = new InvoiceDoc("12345", "John Doe", 100, "USD", 1.0, "Product 1", 1);
		InvoiceDoc invoice2 = new InvoiceDoc("54321", "Jane Smith", 200, "EUR", 1.2, "Product 2", 2);
		InvoiceDoc invoice3 = new InvoiceDoc("67890", "Bob Johnson", 150, "GBP", 1.5, "Product 3", 3);
		InvoiceDoc invoice4 = new InvoiceDoc("09876", "Alice Jones", 300, "JPY", 0.009, "Product 4", 4);
		InvoiceDoc invoice5 = new InvoiceDoc("24680", "Sam Brown", 50, "AUD", 0.75, "Product 5", 5);
		DocumentManager documentManager = new DocumentManager();
		documentManager.addDocument(invoice1);
		documentManager.addDocument(invoice2);
		documentManager.addDocument(invoice3);
		documentManager.addDocument(invoice4);
		documentManager.addDocument(invoice5);

		Thread thread = new Thread(() -> {
			onRefreshButtonClick();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
                e.printStackTrace();
			}
		});
		thread.start();

	}

	@FXML
	protected void onInvoiceButtonClick() throws IOException {
		Stage stage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("invoice-form.fxml"));
		Scene scene = new Scene(fxmlLoader.load());
		stage.setTitle("Создание накладной");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	protected void onPaymentButtonClick() throws IOException {
		Stage stage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("payment-form.fxml"));
		Scene scene = new Scene(fxmlLoader.load());
		stage.setTitle("Создание платежки");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	protected void onApplicationForPaymentButtonClick() throws IOException {
		Stage stage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("application-for-payment-form.fxml"));
		Scene scene = new Scene(fxmlLoader.load());
		stage.setTitle("Создание заявки на оплату");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	protected void onDeleteButtonClick() {
		DocumentManager documentManager = new DocumentManager();
		List<Document> documents = documentManager.getAllDocuments();
		System.out.println(documents);
		for (int i = documents.size() - 1; i > -1; i--) {
			Document document = documents.get(i);
			System.out.println(document + " " + document.getIs());
			if (document.getIs()) {
				documents.remove(i);
			}
		}
		documentManager.saveAllDocuments(documents);
		onRefreshButtonClick();
	}

	@FXML
	protected void onCellClick() {
		tableView.setOnMouseClicked(event -> {
			if (event.getClickCount() == 1 && tableView.getSelectionModel().getSelectedItem() != null) {
				Document document = tableView.getSelectionModel().getSelectedItem();
				document.setIs(!document.getIs());

				tableView.refresh();
			}
			if (event.getClickCount() == 2 && tableView.getSelectionModel().getSelectedItem() != null) {
				System.out.println("DoubleClick");
			}
		});

	}

	@FXML
	protected void onRefreshButtonClick() {
		DocumentManager documentManager = new DocumentManager();
		List<Document> documents = documentManager.getAllDocuments();
		ObservableList<Document> documentsData = FXCollections.observableArrayList(documentManager.getAllDocuments());
		tableView.getItems().clear();
		System.out.println(documents);
		tableView.getItems().addAll(documents);
		tableView.refresh();
	}

}