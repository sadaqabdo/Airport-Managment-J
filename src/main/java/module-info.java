module dashboards {
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;

    opens dashboards to javafx.fxml;
    exports dashboards;
}