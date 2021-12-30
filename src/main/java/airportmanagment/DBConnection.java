package airportmanagment;

import controllers.AdminController;
import controllers.LoginController;
import dashboards.LoginDashboard;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.sql.*;

public class DBConnection {

    private static final String HOST = "localhost";
    private static final int PORT = 1521;
    private static final String DB_NAME = "BDA";
    private static final String USERNAME = "system";
    private static final String PASSWORD = "admin";

    private static Connection connection;
    Statement stm;
    ResultSet rst;

    public static Connection getConnection() {
        String s = "jdbc:oracle:thin:@localhost:1521:XE";
        //jdbc:mysql://localhost:3306/airport_management_db
        try {
            //connection = DriverManager.getConnection("jdbc:oracle:thin:@" + HOST + ":" + PORT + "/" + DB_NAME, USERNAME, PASSWORD);
            connection = DriverManager.getConnection("jdbc:oracle:thin:@" + HOST + ":" + PORT + ":XE", USERNAME, PASSWORD);
        } catch (SQLException se) {
            System.out.println("Connexion failed:" + se);
        }
        return connection;
    }
    /*
    public static void changeScene(ActionEvent event, String fxmlFile, String title, String username){

        try {
            //FXMLLoader loader= new FXMLLoader(LoginDashboard.class.getResource(fxmlFile));
            Parent root = FXMLLoader.load(LoginDashboard.class.getResource(fxmlFile));

            //Parent root =loader.load();
            Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(title);

            stage.setScene(new Scene(root, 600, 400));

            stage.show();

        }catch (Exception e){
            System.out.println("Scene error");
        }

    }

    public static void logInUser(ActionEvent event, String username, String password){
        Connection con = DBConnection.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            preparedStatement=con.prepareStatement("SELECT password FROM employee WHERE username = ?");
            preparedStatement.setString(1,username);
            resultSet =preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()){
                System.out.println("user not found");
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("error");
                alert.show();
            }else{
                while (resultSet.next()){
                    String rPassword=resultSet.getString("password");
                    if (rPassword.equals(password)){
                        changeScene(event, "admin.fxml", "admin", username);
                    }else{
                        System.out.println("Password did not match");
                        Alert alert =new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Password did not match");
                        alert.show();
                    }
                }
            }
        }catch (SQLException se){
            System.out.println(se.getMessage());
        }finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

     */


}