module dashboards {
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires javafx.controls;

    opens dashboards to javafx.fxml;
    opens controllers to javafx.fxml;
    opens classes to javafx.fxml;
    exports classes;
    exports dashboards;
    exports controllers;
}