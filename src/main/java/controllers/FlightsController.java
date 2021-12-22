package controllers;

import airportmanagment.DBConnection;
import  classes.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class FlightsController implements Initializable {
    @FXML private Menu Flight;
    @FXML private VBox vb;
    @FXML private GridPane addGrid,searchGrid;
    @FXML private MenuItem ViewFlightMenu,AddFlightMenu,SearchFlightMenu;
    @FXML private ChoiceBox addsource,adddestination,addterminal,addairplane,add_Pilot;
    @FXML private TextField addDepartDate,addArrivingDate;
    @FXML private TableView<Flight> FlightTable;
    @FXML private TableColumn<Flight,String> source,destination,departDate,arrivingDate,duration;
    @FXML private TableColumn<Flight,String> pilot,flightID,airport,terminal,airplane;

    private ObservableList<Flight> data;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addGrid.setMinWidth(0);
        addGrid.setMaxWidth(0);
        searchGrid.setMinWidth(0);
        searchGrid.setMaxWidth(0);
        flightID.setCellValueFactory(new PropertyValueFactory<Flight,String>("flightID"));
        source.setCellValueFactory(new PropertyValueFactory<Flight,String>("source"));
        destination.setCellValueFactory(new PropertyValueFactory<Flight,String>("destination"));
        arrivingDate.setCellValueFactory(new PropertyValueFactory<Flight,String>("arrivingDate"));
        departDate.setCellValueFactory(new PropertyValueFactory<Flight,String>("departDate"));
        duration.setCellValueFactory(new PropertyValueFactory<Flight,String>("duration"));
        terminal.setCellValueFactory(new PropertyValueFactory<Flight,String>("terminal"));
        airplane.setCellValueFactory(new PropertyValueFactory<Flight,String>("airplaneID"));
        airport.setCellValueFactory(new PropertyValueFactory<Flight,String>("airportID"));
        pilot.setCellValueFactory(new PropertyValueFactory<Flight,String>("pilotID"));
        buildDate();
    }


    public void buildDate(){
        int i = 1;
        data = FXCollections.observableArrayList();
        try{
            ArrayList<String> list = new ArrayList<String>();
            ArrayList<String> list2 = new ArrayList<String>();

            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from Flight;");
            while(rs.next()){
                Flight f = new Flight();
                f.setFlightID(rs.getString(1));
                f.setSource(rs.getString(2));
                f.setDestination(rs.getString(3));
                f.setDepartDate(rs.getString(9));
                f.setArrivingDate(rs.getString(10));
                f.setDuration(f.duration());
                f.setTerminal(rs.getString(4));
                f.setAirplaneID(rs.getString(5));
                f.setPilotID(Integer.parseInt(rs.getString(6)));
                f.setAirportID(rs.getString(7));

                data.add(f);
                i++;
                list.add(rs.getString(2));
                list2.add(rs.getString(3));
            }
            FlightTable.setItems(data);
            ObservableList sourceBox = FXCollections.observableList(list);
            ObservableList destinationBox = FXCollections.observableList(list2);
            addsource.setItems(sourceBox);
            adddestination.setItems(destinationBox);
            con.close();
            st.close();
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }
    /*
    public void insertDate(){
        try{
            int i=0;
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT source from Flight;");
            while(rs.next()){
                Flight f = new Flight();

                f.setApName(rs.getString(1));
                f.setCity(rs.getString(1));
                data.add(f);
                i++;
            }
            FlightTable.setItems(data);

        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Inserting Data");
        }}
    */
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
    }

}
