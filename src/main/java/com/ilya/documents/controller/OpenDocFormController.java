package com.ilya.documents.controller;

import com.ilya.documents.docs.Document;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class OpenDocFormController extends Application implements Initializable {


	private Document document;

	public void setDocument(Document document) {
		this.document = document;
	}

	@FXML
	private TextArea textArea;

	@FXML
	public Button saveButton;

	@FXML
	protected void onOpenDocSaveButtonClick() {
		Stage stage = (Stage) saveButton.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		textArea.setEditable(false);
		document = MainFormController.docToShow;
		textArea.appendText(document.getDocText());
	}

	@Override
	public void start(Stage stage) {
		stage.setOnCloseRequest(e -> Platform.exit());
	}
}
