package controllers;


import airportmanagment.DBConnection;
import airportmanagment.DBMethodes;
import classes.Employee;
import dashboards.Dash;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private VBox pnItems = null;
    @FXML
    private Button btnOverview;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnMenus;

    @FXML
    private Button btnPackages;

    @FXML
    private Button btnSettings;


    @FXML
    private Pane pnlCustomer;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Pane pnlMenus;



    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnCustomers) {
            pnlCustomer.setStyle("-fx-background-color : #1620A1");
            pnlCustomer.toFront();
        }
        if (actionEvent.getSource() == btnMenus) {
            pnlMenus.setStyle("-fx-background-color : #53639F");
            pnlMenus.toFront();
        }
        if (actionEvent.getSource() == btnOverview) {
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
        }
        if(actionEvent.getSource()==btnOrders)
        {
            pnlOrders.setStyle("-fx-background-color : #464F67");
            pnlOrders.toFront();
        }
    }

    @FXML
    private Button button_logout;
    @FXML
    private Button bt_add;
    @FXML
    private Button bt_delete;
    @FXML
    private Button bt_modify;
    @FXML
    private Button bt_refresh;
    @FXML
    private Button button_flights;
    @FXML
    private Button button_tickets;
    @FXML
    private Button button_employee;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDate();

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
                DBMethodes.changeEmployee(event, "employees.fxml", "employee",null );
            }
        });
    }


    @FXML
    public void getModifyView(MouseEvent mouseEvent) {

        try {

            employee = employeeTable.getSelectionModel().getSelectedItem();
            query = "UPDATE `employee` SET "
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
            query = "DELETE FROM `employee` WHERE id  ="+employee.getId();
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
    private TableColumn<Employee, Integer> idCol;
    @FXML
    private TableColumn<Employee, String> nameCol;
    @FXML
    private TableColumn<Employee, Integer> salaryCol;
    @FXML
    private TableColumn<Employee, String> passwordCol;

    @FXML
    private void refreshTable() {
        try {
            EmployeeList.clear();

            query = "SELECT * FROM `employee`";
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
    private TextField tf_id;
    @FXML
    private TextField tf_name;
    @FXML
    private TextField tf_salary;
    @FXML
    private TextField tf_password;

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
                query = "INSERT INTO `employee`( `id`, `name`, `salary`, `password`) VALUES (?,?,?,?)";
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

    public void tableview(MouseEvent mouseEvent) {
        employee = employeeTable.getSelectionModel().getSelectedItem();
        setTextField(String.valueOf(employee.getId()),employee.getName(),String.valueOf(employee.getSalary()), employee.getPassword());

    }
}
