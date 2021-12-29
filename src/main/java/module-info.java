module dashboards {
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires javafx.controls;
<<<<<<< HEAD
    requires mysql.connector.java;
=======
    requires com.jfoenix;
    requires java.base;
    requires jfxtras.controls;
>>>>>>> 9562eb6e3a4e1c076d6460244ca2cc39831b7759

    opens dashboards to javafx.fxml;
    opens controllers to javafx.fxml;
    opens classes to javafx.fxml;
    exports dashboards;
    exports controllers;
    exports classes;
}