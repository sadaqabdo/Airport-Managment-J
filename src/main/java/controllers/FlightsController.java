package controllers;

import airportmanagment.DBConnection;
import  classes.Airport;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.SimpleStyleableObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class FlightsController implements Initializable {
    @FXML private Menu Flight;
    @FXML private VBox vb;
    @FXML private GridPane addGrid,searchGrid;
    @FXML private MenuItem ViewFlightMenu,AddFlightMenu,SearchFlightMenu;
    @FXML private ChoiceBox addSource,addDestination,addTerminal,addAirplane,add_Pilot;
    @FXML private TextField addDepartDate,addArrivingDate;
    @FXML private TableView<Airport> FlightTable;
    @FXML private TableColumn<Airport,String> Source ;
    @FXML private TableColumn<Airport,String> Destination ;

    private ObservableList<Airport> data;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addGrid.setMinWidth(0);
        addGrid.setMaxWidth(0);
        searchGrid.setMinWidth(0);
        searchGrid.setMaxWidth(0);
        Source.setCellValueFactory(new PropertyValueFactory<Airport,String>("apName"));
        Destination.setCellValueFactory(new PropertyValueFactory<Airport,String>("city"));
        buildDate();
    }


    public void buildDate(){
        int i = 1;
        data = FXCollections.observableArrayList();
        try{
            ArrayList<String> list = new ArrayList<String>();
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT source from Flight;");
            while(rs.next()){
                Airport cm = new Airport();
                cm.setApID(i);
                cm.setApName(rs.getString(1));
                cm.setCity(rs.getString(1));
                data.add(cm);
                i++;
                list.add(rs.getString(1));
            }
            FlightTable.setItems(data);
            ObservableList observableList = FXCollections.observableList(list);
            addSource.setItems(observableList);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }
    @FXML
    private void SearchFlightMenuClbck(){
        searchGrid.setMinWidth(260);
        searchGrid.setMaxWidth(460);
    }
    @FXML
    private void ViewFlightMenuClbck(){
    }
    @FXML
    private void AddFlightMenuClbck(){
        addGrid.setMinWidth(260);
        addGrid.setMaxWidth(460);
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
    private void onAddFlight(){
        addDestination.setValue(addSource.getValue());
    }

}