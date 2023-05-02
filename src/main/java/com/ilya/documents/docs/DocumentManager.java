package com.ilya.documents.docs;

import java.util.ArrayList;
import java.util.List;

public class DocumentManager {

	private static List<Document> documents;

	synchronized public void addDocument(Document document) {
		if (documents == null) documents = new ArrayList<>();
		documents.add(document);
	}

	synchronized public List<Document> getAllDocuments() {
		if (documents == null) documents = new ArrayList<>();
		return documents;
	}

	synchronized public void removeDocument(Document document) {
		if (documents.size() == 1) documents.clear();
		documents.remove(document);

	}

	synchronized public void saveAllDocuments(List<Document> documents) {
		DocumentManager.documents = new ArrayList<>(documents);
	}
}
