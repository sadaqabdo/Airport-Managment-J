package airportmanagment;

import dashboards.AdminDashboard;
import dashboards.FlightsDashboard;
import dashboards.LoginDashboard;
import classes.*;
import dashboards.TicketsDashboard;

import java.sql.Connection;

import static javafx.application.Application.launch;

public class Main {
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();
        if (con == null) {
            System.out.println("Connexion failed:");
        } else {
            System.out.println("Connexion success:");
        }

        launch(LoginDashboard.class, args);
    }
    Employee e=new Employee();

}
