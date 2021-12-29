package controllers;

import airportmanagment.DBConnection;
import classes.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ResourceBundle;

public class EmployeesController implements Initializable {
    @FXML private GridPane addGrid,searchGrid;
    @FXML private TableView<Employee> EmpTable;
    @FXML private TableColumn<Employee, String> nameclmn;
    @FXML private TableColumn<Employee, Integer> ageclmn;
    @FXML private TableColumn<Employee, String> genderclmn;
    @FXML private TableColumn<Employee, String> nationalityclmn;
    @FXML private TableColumn<Employee, String> jobclmn;

    @FXML private TextField empage;
    @FXML private TextField empgender;
    @FXML private TextField empjob;
    @FXML private TextField empname;
    @FXML private TextField empnationality;

    private ObservableList<Employee> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        nameclmn.setCellValueFactory(new PropertyValueFactory<Employee,String>("name"));
        ageclmn.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("age"));
        genderclmn.setCellValueFactory(new PropertyValueFactory<Employee,String>("gender"));
        nationalityclmn.setCellValueFactory(new PropertyValueFactory<Employee,String>("nationality"));
        jobclmn.setCellValueFactory(new PropertyValueFactory<Employee,String>("job"));
        EmpTable.setItems(data);
        //EmpTable.getColumns().addAll(nameclmn, ageclmn,genderclmn,nationalityclmn,jobclmn);

    }

    @FXML
    private void SearchEmpMenuClbck(){
        searchGrid.setMinWidth(350);
        searchGrid.setMaxWidth(350);
    }
    @FXML
    private void ViewEmpMenuClbck(){
    }
    @FXML
    private void AddEmpMenuClbck(){
        addGrid.setMinWidth(350);
        addGrid.setMaxWidth(350);
    }

    @FXML
    private void onCloseAddBtn(){
        addGrid.setMinWidth(0);
        addGrid.setMaxWidth(0);
    }
    @FXML
    private void onCloseSearchBtn(){
        searchGrid.setMinWidth(0);
        searchGrid.setMaxWidth(0);
    }

    @FXML
    public void onAddEmp() {
        String ename = empname.getText();
        Integer eage = Integer.parseInt(empage.getText());
        String egender =empgender.getText();
        String enationality = empnationality.getText();
        String ejob = empjob.getText();
        Employee emp = new Employee(ename, eage, egender, enationality, ejob);
        AddtoTable(emp);
        clearFields();
        insertToDb(emp);
    }

    private void insertToDb(Object e) {
        try{
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            PreparedStatement preparedStatement=null;

            if ((Employee)e instanceof Employee){
                String sql = "Insert into Employee(name,age,gender,nationality,job" +
                             "values(?,?,?,?,?);";
                int resultSet = 0;
                System.out.print(((Employee) e).getName());
                System.out.println(((Employee) e).getAge());
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, ((Employee) e).getName());
                preparedStatement.setInt(2,  ((Employee) e).getAge());
                preparedStatement.setString(3, ((Employee) e).getGender());
                preparedStatement.setString(4, ((Employee) e).getNationality());
                preparedStatement.setString(5, ((Employee) e).getJob());


                resultSet=preparedStatement.executeUpdate();
                System.out.println("A new record was inserted successfully!");
                con.close();
            }


        }
        catch(Exception ee){
            ee.printStackTrace();
            System.out.println("Error on Inserting Data");
        }
    }

    public void AddtoTable(Employee emp){
        data.add(emp);
        EmpTable.setItems(data);
        //EmpTable.getItems().add(emp);

    }
    private void clearFields() {
        empname.clear();
        empage.clear();
        empgender.clear();
        empnationality.clear();
        empjob.clear();
    }

    @FXML
    void onDeleteEmp(ActionEvent event) {
        int selected = EmpTable.getSelectionModel().getSelectedIndex();
        EmpTable.getItems().remove(selected);
    }
    public void backToMain(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/dashboards/Main.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}