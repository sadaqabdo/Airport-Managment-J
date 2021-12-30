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

public class EmployeesController implements Initializable {

    @FXML
    private TextField search_barre;

    @FXML
    private TextField tf_age;

    @FXML
    private TextField tf_gender;

    @FXML
    private TextField tf_job;

    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_nationality;
    @FXML
    private Pane pnlOverview;
    @FXML
    private Button button_logout;
    @FXML
    private Button button_flights;
    @FXML
    private Button button_tickets;
    @FXML
    private Button button_employee;
    @FXML
    private Button bt_exit;

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
                DBMethodes.changeTicket(event, "Tickets.fxml", "ticket",null );
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
                    + "name=?,"
                    + "age=?,"
                    + "nationality=?,"
                    + "job=?,"
                    + "gender= ? WHERE name = '" + employee.getName() + "'";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, tf_name.getText());
            preparedStatement.setString(2,  tf_age.getText());
            preparedStatement.setString(3, tf_nationality.getText());
            preparedStatement.setString(4, tf_job.getText());
            preparedStatement.setString(5, tf_gender.getText());
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
            query = "DELETE FROM employees WHERE name = '"+employee.getName()+"'";
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
    private TableColumn<Employee, String> genderCol;

    @FXML
    private TableColumn<Employee, String> jobCol;

    @FXML
    private TableColumn<Employee, String> nameCol;

    @FXML
    private TableColumn<Employee, String> nationalityCol;
    @FXML
    private TableColumn<Employee, Integer> ageCol;

    @FXML
    private void refreshTable() {
        try {
            EmployeeList.clear();

            query = "SELECT * FROM employees";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                EmployeeList.add(new Employee(
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("gender"),
                        resultSet.getString("nationality"),
                        resultSet.getString("job")));

                employeeTable.setItems(EmployeeList);

            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private void loadDate() {
        refreshTable();

        ageCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        jobCol.setCellValueFactory(new PropertyValueFactory<>("job"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        nationalityCol.setCellValueFactory(new PropertyValueFactory<>("nationality"));

    }
    @FXML
    private void getAddView(MouseEvent event) {

        connection = DBConnection.getConnection();
        String name = tf_name.getText();
        String age = tf_age.getText();
        String gender = tf_gender.getText();
        String job = tf_job.getText();
        String nationality = tf_nationality.getText();

        if (name.isEmpty() || name.isEmpty() || age.isEmpty() || age.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
        } else {

            try {
                query = "INSERT INTO employees (name, age, gender, nationality, job) VALUES (?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, tf_name.getText());
                preparedStatement.setString(2, tf_age.getText());
                preparedStatement.setString(4, tf_nationality.getText());
                preparedStatement.setString(5, tf_job.getText());
                preparedStatement.setString(3, tf_gender.getText());
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
        tf_name.setText(null);
        tf_job.setText(null);
        tf_age.setText(null);
        tf_nationality.setText(null);
        tf_gender.setText(null);
    }

    void setTextField(String name, String age, String gender, String nationality, String job) {

        tf_name.setText(name);
        tf_job.setText(job);
        tf_age.setText(age);
        tf_nationality.setText(nationality);
        tf_gender.setText(gender);

    }

    public void tableview(MouseEvent mouseEvent) {
        try {
            Employee e = employeeTable.getSelectionModel().getSelectedItem();
            setTextField(e.getName(),String.valueOf(e.getAge()),e.getGender(),e.getNationality(), e.getJob());
        }catch (Exception ee){
            ee.getMessage();
        }


    }
}
