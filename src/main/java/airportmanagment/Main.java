package airportmanagment;

import dashboards.TicketsDashboard;
import javafx.application.Application;

import java.sql.Connection;

public class Main{
    public static void main(String[] args) {

        Connection con = DBConnection.getConnection();
        if (con == null) {
            System.out.println("Connexion failed");
        } else {
            System.out.println("Connexion success");

        }
        //DBConnection.getData();
        Application.launch(TicketsDashboard.class);

    }
}
