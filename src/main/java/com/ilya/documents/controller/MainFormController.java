package com.ilya.documents.controller;

import com.ilya.documents.MainApplication;
import com.ilya.documents.docs.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;


public class MainFormController implements Initializable {

	public static Document docToShow;

	@FXML
	private TableView<Document> tableView;

	@FXML
	private TableColumn<Document, String> nameColumn;

	@FXML
	private TableColumn<Document, CheckBox> isForDeleteColumn;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		isForDeleteColumn.setCellValueFactory(new PropertyValueFactory<>("isForDelete"));


		nameColumn.setCellValueFactory(new PropertyValueFactory<>("infoForTable"));
		nameColumn.prefWidthProperty().bind(tableView.widthProperty().subtract(35));

		// Загрузка тестовых данных:
		DocumentManager documentManager = new DocumentManager();
		documentManager.addDocument(new PaymentDoc("003", "user3", 3000, "employee3"));
		documentManager.addDocument(new InvoiceDoc("54321", "Jane Smith", 200, "EUR", 1.2, "Product 2", 2));
		documentManager.addDocument(new PaymentDoc("005", "user5", 5000, "employee5"));
		documentManager.addDocument(new PaymentDoc("004", "user4", 4000, "employee4"));
		documentManager.addDocument(new InvoiceDoc("09876", "Alice Jones", 300, "JPY", 0.009, "Product 4", 4));
		documentManager.addDocument(new ApplicationForPaymentDoc("001", "user1", "partner1", 1000, "USD", 1.0, 0.0));
		documentManager.addDocument(new ApplicationForPaymentDoc("004", "user4", "partner4", 4000, "EUR", 1.2, 0.1));
		documentManager.addDocument(new InvoiceDoc("67890", "Bob Johnson", 150, "GBP", 1.5, "Product 3", 3));
		documentManager.addDocument(new ApplicationForPaymentDoc("002", "user2", "partner2", 2000, "EUR", 1.2, 0.1));

		Thread refreshTableThread = new Thread(() -> {
			while (true) {
				onRefreshButtonClick();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		});
		refreshTableThread.start();

	}

	@FXML
	protected void onInvoiceButtonClick() throws IOException {
		Stage stage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("invoice-form.fxml"));
		Scene scene = new Scene(fxmlLoader.load());
		stage.setTitle("Создание накладной");
		stage.setMinHeight(390);
		stage.setMinWidth(315);
		stage.setMaxHeight(390);
		stage.setMaxWidth(315);
		stage.setScene(scene);
		stage.show();
	}

	// Чтение файлов и добавление объектов в таблицу
	// на их основе
	@FXML
	protected void onLoadButtonClick() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Выберите файл .txt");
		fileChooser.getExtensionFilters().add(
				new FileChooser.ExtensionFilter("Текстовый файл (*.txt)", "*.txt")
		);
		Stage stage = new Stage();
		File file = fileChooser.showOpenDialog(stage);
		DocumentManager documentManager = new DocumentManager();
		if (file != null) {
			try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
				Document document;
				String tempStr = fileReader.readLine().trim();
				System.out.println(tempStr);
				if (tempStr.equals("Накладная")) {
					document = new InvoiceDoc(
							parseFieldFromDoc(fileReader.readLine()),
							LocalDate.parse(parseFieldFromDoc(fileReader.readLine())),
							parseFieldFromDoc(fileReader.readLine()),
							Integer.parseInt(parseFieldFromDoc(fileReader.readLine())),
							parseFieldFromDoc(fileReader.readLine()),
							Double.parseDouble(parseFieldFromDoc(fileReader.readLine())),
							parseFieldFromDoc(fileReader.readLine()),
							Integer.parseInt(parseFieldFromDoc(fileReader.readLine()))
					);
					documentManager.addDocument(document);
				} else if (tempStr.equals("Платежка")) {
					document = new PaymentDoc(
							parseFieldFromDoc(fileReader.readLine()),
							LocalDate.parse(parseFieldFromDoc(fileReader.readLine())),
							parseFieldFromDoc(fileReader.readLine()),
							Integer.parseInt(parseFieldFromDoc(fileReader.readLine())),
							parseFieldFromDoc(fileReader.readLine())
					);
					documentManager.addDocument(document);
				} else if (tempStr.equals("Заявка на оплату")) {
					document = new ApplicationForPaymentDoc(
							parseFieldFromDoc(fileReader.readLine()),
							LocalDate.parse(parseFieldFromDoc(fileReader.readLine())),
							parseFieldFromDoc(fileReader.readLine()),
							parseFieldFromDoc(fileReader.readLine()),
							Integer.parseInt(parseFieldFromDoc(fileReader.readLine())),
							parseFieldFromDoc(fileReader.readLine()),
							Double.parseDouble(parseFieldFromDoc(fileReader.readLine())),
							Double.parseDouble(parseFieldFromDoc(fileReader.readLine()))
					);
					documentManager.addDocument(document);
				}

			} catch (IOException fileReadingException) {
				fileReadingException.printStackTrace();
			} catch (Exception corruptedFiles) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Ошибка");
				alert.setHeaderText("Ошибка чтения");
				alert.setContentText("Файл, который Вы пытаетесь открыть, поврежден.");
				alert.showAndWait().ifPresent(rs -> {
				});
			}
			onRefreshButtonClick();
		}
	}

	// Необходим для парсинга строк из файлов
	private String parseFieldFromDoc(String field) {
		StringBuilder stringBuilder = new StringBuilder(field);
		while (stringBuilder.length() > 0) {
			if (stringBuilder.charAt(0) == ':') {
				stringBuilder.deleteCharAt(0);
				stringBuilder.deleteCharAt(0);
				break;
			}
			stringBuilder.deleteCharAt(0);
		}
		return stringBuilder.toString();
	}

	@FXML
	protected void onSaveButtonClick() {
		Document document = tableView.getSelectionModel().getSelectedItem();
		if (document != null) {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Сохранить как .txt");
			fileChooser.getExtensionFilters().add(
					new FileChooser.ExtensionFilter("Текстовый файл (*.txt)", "*.txt")
			);
			Stage stage = new Stage();
			File file = fileChooser.showSaveDialog(stage);
			if (file != null) {
				try (FileWriter fileWriter = new FileWriter(file)) {
					fileWriter.write(document.getDocText());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@FXML
	protected void onPaymentButtonClick() throws IOException {
		Stage stage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("payment-form.fxml"));
		Scene scene = new Scene(fxmlLoader.load());
		stage.setMinHeight(390);
		stage.setMinWidth(315);
		stage.setMaxHeight(390);
		stage.setMaxWidth(315);
		stage.setTitle("Создание платежки");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	protected void onApplicationForPaymentButtonClick() throws IOException {
		Stage stage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("application-for-payment-form.fxml"));
		Scene scene = new Scene(fxmlLoader.load());
		stage.setTitle("Создание заявки на оплату");
		stage.setMinHeight(390);
		stage.setMinWidth(315);
		stage.setMaxHeight(390);
		stage.setMaxWidth(315);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	protected void onOpenDocButtonClick() throws IOException {
		docToShow = tableView.getSelectionModel().getSelectedItem();
		if (docToShow != null) {
			Stage stage = new Stage();
			FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("open-doc-form.fxml"));
			Scene scene = new Scene(fxmlLoader.load());
			stage.setMinHeight(400);
			stage.setMinWidth(400);
			stage.setTitle("Просмотр документа");
			stage.setScene(scene);
			stage.show();
		}
	}

	@FXML
	protected void onDeleteButtonClick() {
		DocumentManager documentManager = new DocumentManager();
		List<Document> documents = documentManager.getAllDocuments();
		for (int i = documents.size() - 1; i > -1; i--) {
			Document document = documents.get(i);
			if (document.toDelete()) {
				documents.remove(i);
			}
		}
		documentManager.saveAllDocuments(documents);
		onRefreshButtonClick();
	}

	@FXML
	protected void onRefreshButtonClick() {
		DocumentManager documentManager = new DocumentManager();
		ObservableList<Document> documentsData = FXCollections.observableArrayList(documentManager.getAllDocuments());
		tableView.getItems().clear();
		tableView.getItems().addAll(documentsData);
		tableView.refresh();
	}

	@FXML
	protected void onExitButtonClick() {
		Platform.exit();
		System.exit(0);
	}

}