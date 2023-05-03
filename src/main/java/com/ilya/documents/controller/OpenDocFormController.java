package com.ilya.documents.controller;

import com.ilya.documents.HelloApplication;
import com.ilya.documents.docs.Document;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import javax.print.Doc;
import java.net.URL;
import java.util.ResourceBundle;

public class OpenDocFormController implements Initializable {


	private Document document;

	public void setDocument(Document document) {
		System.out.println("FORM SET OPEN: " + document);
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
		document = MainFormController.docToShow;
		textArea.appendText(document.getDocText());
	}
}
