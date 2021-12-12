module dashboards {
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires javafx.controls;

    opens dashboards to javafx.fxml;
    exports dashboards;
    exports controllers;
    opens controllers to javafx.fxml;
}