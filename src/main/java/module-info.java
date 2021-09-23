module com.example.testproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignment1 to javafx.fxml;
    exports com.example.assignment1;
}