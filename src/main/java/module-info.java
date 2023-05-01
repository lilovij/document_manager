module com.example.documents2 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.documents2 to javafx.fxml;
    exports com.example.documents2;
}