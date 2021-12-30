package controllers;

import airportmanagment.DBConnection;
import classes.Flight;
import dashboards.TicketsDashboard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//import jfxtras.scene.control.LocalDateTimeTextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/*
public class FlightsController implements Initializable {
    @FXML private Menu Flight;
    @FXML private VBox vb;
    @FXML private GridPane addGrids;
    @FXML private MenuItem ViewFlightMenu,AddFlightMenu,SearchFlightMenu;
    @FXML private MenuItem ViewTicketMenu,AddTicketMenu,SearchTicketMenu;
    @FXML private TextField sourceSearch, destinationSearch;
    @FXML private DatePicker datepickersearch;
    @FXML private ChoiceBox addsource,adddestination,addterminal,addairplane,add_pilot;
    @FXML private LocalDateTimeTextField adddepartDate,addarrivingDate;
    @FXML private TableView<Flight> FlightTable;
    @FXML private TableColumn<Flight,String> source,destination,departDate,arrivingDate,duration;
    @FXML private TableColumn<Flight,String> pilot,flightID,airport,terminal,airplane;

    private Stage stage;
    private Scene scene;
    public Parent root;
    private ObservableList<Flight> data = FXCollections.observableArrayList();




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addGrids.setMinWidth(0);
        addGrids.setMaxWidth(0);
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
        try{
            ArrayList<String> sources = new ArrayList<String>();
            ArrayList<String> destinations = new ArrayList<String>();
            List<String> terminals = Arrays.asList("A","B","C","D");
            List<String> airplanes = Arrays.asList("B-147","B-176","C-293","D-321");
            ArrayList<String> pilots = new ArrayList<String>();

            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            Statement st1 = con.createStatement();
            Statement st2 = con.createStatement();
            Statement st3 = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from Flight order by arrivingdate desc;");
            ResultSet r1 = st1.executeQuery("select Distinct source from Flight;");
            ResultSet r2 = st2.executeQuery("select Distinct destination from Flight;");
            ResultSet r3 = st3.executeQuery("select Distinct pilotid from Flight;");


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
            }
            while (r1.next()){
                sources.add(r1.getString(1));
            }
            while (r2.next()){
                destinations.add(r2.getString(1));
            }
            while (r3.next()){
                pilots.add(r3.getString(1));
            }


            FlightTable.setItems(data);

            ObservableList sourceBox = FXCollections.observableList(sources);
            ObservableList destinationBox = FXCollections.observableList(destinations);
            ObservableList pilotsBox = FXCollections.observableList(pilots);
            ObservableList airplanesBox = FXCollections.observableList(airplanes);
            ObservableList terminalsBox = FXCollections.observableList(terminals);
            addsource.setItems(sourceBox);
            adddestination.setItems(destinationBox);
            addairplane.setItems(airplanesBox);
            add_pilot.setItems(pilotsBox);
            addterminal.setItems(terminalsBox);
            con.close();
            st.close();
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }
    public void insertData(Object obj){
        try{
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            PreparedStatement preparedStatement=null;

            if ((Flight)obj instanceof Flight){
                String sql = "Insert into Flight(flightid,source,destination,departdate," +
                        "arrivingdate,duration,terminal,airportid,pilotid,airplaneid)" +
                        "values(?,?,?,?,?,?,?,?,?,?);";

                int resultSet = 0;
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, ((Flight) obj).getFlightID());
                preparedStatement.setString(2,  ((Flight) obj).getSource());
                preparedStatement.setString(3, ((Flight) obj).getDestination());
                preparedStatement.setString(4, ((Flight) obj).getDepartDate().toString());
                preparedStatement.setString(5, ((Flight) obj).getArrivingDate().toString());
                preparedStatement.setString(6, ((Flight) obj).getDuration());
                preparedStatement.setString(7, ((Flight) obj).getTerminal());
                preparedStatement.setString(8, "null");
                preparedStatement.setInt(9, ((Flight) obj).getPilotID());
                preparedStatement.setString(10, ((Flight) obj).getAirplaneID());

                resultSet=preparedStatement.executeUpdate();
                System.out.println("A new record was inserted successfully!");
                data.add(0,(classes.Flight) obj);
                FlightTable.setItems(data);
                con.close();
                }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Inserting Data");
        }}

    private void searchData(Object obj){
        ObservableList<Flight> donnee = FXCollections.observableArrayList();

        try{
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            PreparedStatement preparedStatement=null;

            if ((Flight)obj instanceof Flight){
                String sql = "Select source from Flight where source = ?;";
                        //"and destination like lower(?) and departdate > ? and arrivingdate < ? and terminal like ? and airplaneid like ? and pilotid like ?;";

                ResultSet resultSet;
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1,  "'"+ ((Flight) obj).getSource()+  "'");
                System.out.println(preparedStatement.getMetaData());

                /*preparedStatement.setString(2, ((Flight) obj).getDestination());
                preparedStatement.setString(3, ((Flight) obj).getDepartDate().toString());
                preparedStatement.setString(4, ((Flight) obj).getArrivingDate().toString());
                preparedStatement.setString(5, ((Flight) obj).getTerminal());
                preparedStatement.setInt(6, ((Flight) obj).getPilotID());
                preparedStatement.setString(7, ((Flight) obj).getAirplaneID());
                preparedStatement = con.prepareStatement(sql);

                resultSet = preparedStatement.executeQuery();
                System.out.println("A new record was inserted successfully!");
                //data.add(0,(classes.Flight) obj);
                //data.sorted();
                //FlightTable.setItems(donnee);
                while(resultSet.next()){
                    System.out.println(resultSet.getString(1));
                }
                con.close();
            }




        }
    catch(Exception e){
        e.printStackTrace();
        System.out.println("Error on Searching Data");
    }

    }
    @FXML
    private void SearchFlightMenuClbck(){
    }
    @FXML
    private void ViewFlightMenuClbck(){
    }
    @FXML
    private void AddFlightMenuClbck(){
        addGrids.setMinWidth(260);
        addGrids.setMaxWidth(460);
    }
    @FXML
    private void SearchTicketMenuClbck(){
    }
    @FXML
    private void ViewTicketMenuClbck(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(TicketsDashboard.class.getResource("/dashboards/Ticket.fxml"));
        Stage stage = (Stage) (vb).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void AddTicketMenuClbck(){
        addGrids.setMinWidth(260);
        addGrids.setMaxWidth(460);
    }
    @FXML
    private void onCloseAddBtn(){
        addGrids.setMinWidth(0);
        addGrids.setMaxWidth(0);
    }
    @FXML
    private void onCloseSearchBtn(){
    }
    @FXML
    private void onAddFlight() throws ParseException {
        String source = addsource.getValue().toString();
        String destination = adddestination.getValue().toString();
        String arrivingdate = addarrivingDate.getText();
        String departdate = adddepartDate.getText();
        String terminal = addterminal.getValue().toString();
        Integer pilot = Integer.parseInt(add_pilot.getValue().toString());
        String airplane = addairplane.getValue().toString();

        Flight e = new Flight(source,destination,departdate,arrivingdate,terminal,airplane,pilot);

        insertData(e);
    }
    @FXML
    private void onsearchflight(ActionEvent event) throws ParseException {
        String source = addsource.getValue().toString();
        String destination = adddestination.getValue().toString();
        String arrivingdate = addarrivingDate.getText();
        String departdate = adddepartDate.getText();
        String terminal = addterminal.getValue().toString();
        Integer pilot = Integer.parseInt(add_pilot.getValue().toString());
        String airplane = addairplane.getValue().toString();
        Flight e = new Flight(source,destination,departdate,arrivingdate,terminal,airplane,pilot);

        searchData(e);
    }


} */