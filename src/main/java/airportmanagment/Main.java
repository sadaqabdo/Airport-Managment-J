package airportmanagment;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection con=DBConnection.getConnection();
        if (con==null) {
            System.out.println("Connexion failed:");
        }else{
            System.out.println("Connexion success:");

        }
    }
}
