package airportmanagment;

import dashboards.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBMethodes {

    public static void changeScene(ActionEvent event, String fxmlFile, String title, String username) {

        try {
            //FXMLLoader loader= new FXMLLoader(LoginDashboard.class.getResource(fxmlFile));
            Parent root = FXMLLoader.load(LoginDashboard.class.getResource(fxmlFile));

            //Parent root =loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(title);

            stage.setScene(new Scene(root));

            stage.show();

        } catch (Exception e) {
            System.out.println("Scene error");
        }

    }
    public static void changeHome(ActionEvent event, String fxmlFile, String title, String username) {

        try {
            //FXMLLoader loader= new FXMLLoader(LoginDashboard.class.getResource(fxmlFile));
            Parent root = FXMLLoader.load(Dash.class.getResource(fxmlFile));

            //Parent root =loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(title);

            stage.setScene(new Scene(root));

            stage.show();

        } catch (Exception e) {
            System.out.println("Scene error");
        }

    }
    public static void changeFlight(ActionEvent event, String fxmlFile, String title, String username) {

        try {
            //FXMLLoader loader= new FXMLLoader(LoginDashboard.class.getResource(fxmlFile));
            Parent root = FXMLLoader.load(FlightsDashboard.class.getResource(fxmlFile));

            //Parent root =loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(title);

            stage.setScene(new Scene(root));

            stage.show();

        } catch (Exception e) {
            System.out.println("Scene error");
        }

    }
    public static void changeEmployee(ActionEvent event, String fxmlFile, String title, String username) {

        try {
            //FXMLLoader loader= new FXMLLoader(LoginDashboard.class.getResource(fxmlFile));
            Parent root = FXMLLoader.load(EmployeesDashboard.class.getResource(fxmlFile));

            //Parent root =loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(title);

            stage.setScene(new Scene(root));

            stage.show();

        } catch (Exception e) {
            System.out.println("Scene error");
        }

    }
    public static void changeTicket(ActionEvent event, String fxmlFile, String title, String username) {

        try {
            //FXMLLoader loader= new FXMLLoader(LoginDashboard.class.getResource(fxmlFile));
            Parent root = FXMLLoader.load(TicketsDashboard.class.getResource(fxmlFile));

            //Parent root =loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(title);

            stage.setScene(new Scene(root));

            stage.show();

        } catch (Exception e) {
            System.out.println("Scene error");
        }

    }
    public static void logInUser(ActionEvent event, String username, String password) {
        Connection con = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = con.prepareStatement("SELECT password FROM employees WHERE job= 'manager' and name = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("user not found");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("error");
                alert.show();
            }else {
                while (resultSet.next()) {
                    String rPassword = resultSet.getString("password");
                    if (rPassword.equals(password)) {
                        changeEmployee(event, "employee.fxml", "employee", username);
                    } else {
                        System.out.println("Password did not match");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Password did not match");
                        alert.show();
                    }
                }
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}