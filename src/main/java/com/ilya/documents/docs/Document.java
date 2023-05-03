package com.ilya.documents.docs;

import javafx.scene.control.CheckBox;

public interface Document {

	String getDocText();

	CheckBox getIsForDelete();

	boolean toDelete();

}
