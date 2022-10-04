module com.bashko.itmo.guessthenumber {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.bashko.itmo.guessthenumber to javafx.fxml;
    exports com.bashko.itmo.guessthenumber;
}