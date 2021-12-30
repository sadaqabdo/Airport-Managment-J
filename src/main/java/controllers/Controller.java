package controllers;


import airportmanagment.DBConnection;
import airportmanagment.DBMethodes;
import classes.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Controller implements Initializable {



    @FXML
    private Pane pnlOverview;
    @FXML
    private Button button_logout, bt_add, bt_delete, bt_modify, bt_exit;
    @FXML
    private Button bt_refresh, button_flights, button_tickets, button_employee;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDate();

        bt_exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            }
        });

        button_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBMethodes.changeScene(event, "login.fxml", "login",null );
            }
        });
        button_flights.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBMethodes.changeFlight(event, "flights.fxml", "flights",null );
            }
        });
        button_tickets.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBMethodes.changeTicket(event, "Ticket.fxml", "ticket",null );
            }
        });
        button_employee.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBMethodes.changeEmployee(event, "employee.fxml", "employee",null );
            }
        });
    }


    @FXML
    public void getModifyView(MouseEvent mouseEvent) {

        try {
            employee = employeeTable.getSelectionModel().getSelectedItem();
            query = "UPDATE employees SET "
                    + "`id`=?,"
                    + "`name`=?,"
                    + "`salary`=?,"
                    + "`password`= ? WHERE id = '" + employee.getId() + "'";
          
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, tf_id.getText());
            preparedStatement.setString(2, tf_name.getText());
            preparedStatement.setString(3, tf_salary.getText());
            preparedStatement.setString(4, tf_password.getText());
            preparedStatement.execute();
            refreshTable();
            clean();
        }catch (SQLException se){
            se.printStackTrace();
        }
    }

    @FXML
    public void getDeleteView(MouseEvent mouseEvent) {
        try{
            employee = employeeTable.getSelectionModel().getSelectedItem();
            query = "DELETE FROM employees WHERE id  ="+employee.getId();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            refreshTable();
            clean();
        }catch (SQLException se){
            se.printStackTrace();
        }
    }

    String query = null;
    //Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Employee employee = null ;
    ObservableList<Employee> EmployeeList = FXCollections.observableArrayList();
    Connection connection = DBConnection.getConnection();
  
    @FXML
    private TableView<Employee> employeeTable;
    @FXML
    private TableColumn<Employee, Integer> idCol, salaryCol;
    @FXML
    private TableColumn<Employee, String> nameCol, passwordCol;

    @FXML
    private void refreshTable() {
        try {
            EmployeeList.clear();
            query = "SELECT * FROM employees";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                EmployeeList.add(new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("salary"),
                        resultSet.getString("password")));
                employeeTable.setItems(EmployeeList);

            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private void loadDate() {
        refreshTable();

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<>("salary"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));

    }
    @FXML
    private TextField tf_id, tf_name, tf_salary, tf_password;


    @FXML
    private void getAddView(MouseEvent event) {

        connection = DBConnection.getConnection();
        String id = tf_id.getText();
        String name = tf_name.getText();
        String salary = tf_salary.getText();
        String password = tf_password.getText();

        if (name.isEmpty() || name.isEmpty() || salary.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();

        } else {

            try {
                query = "INSERT INTO employee( `id`, `name`, `salary`, `password`) VALUES (?,?,?,?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, tf_id.getText());
                preparedStatement.setString(2, tf_name.getText());
                preparedStatement.setString(3, tf_salary.getText());
                preparedStatement.setString(4, tf_password.getText());
                preparedStatement.execute();
            }catch(SQLIntegrityConstraintViolationException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Duplicate id");
                alert.showAndWait();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

            clean();
            refreshTable();
        }

    }

    @FXML
    private void clean() {
        tf_id.setText(null);
        tf_name.setText(null);
        tf_salary.setText(null);
        tf_password.setText(null);

    }

    void setTextField(String id, String name, String salary, String password) {

        tf_id.setText(id);
        tf_name.setText(name);
        tf_salary.setText(salary);
        tf_password.setText(password);
    }
    @FXML
    public void tableview(MouseEvent mouseEvent) {
        try {
            employee = employeeTable.getSelectionModel().getSelectedItem();
            setTextField(String.valueOf(employee.getId()),employee.getName(),String.valueOf(employee.getSalary()), employee.getPassword());
        }catch (Exception e){
            e.getMessage();
        }


    }
}
