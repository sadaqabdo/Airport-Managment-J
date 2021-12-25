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

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class FlightsController implements Initializable {
    @FXML private Menu Flight;
    @FXML private VBox vb;
    @FXML private GridPane addGrid,searchGrid;
    @FXML private MenuItem ViewFlightMenu,AddFlightMenu,SearchFlightMenu;
    @FXML private MenuItem ViewTicketMenu,AddTicketMenu,SearchTicketMenu;

    @FXML private ChoiceBox addsource,adddestination,addterminal,addairplane,add_pilot;
    @FXML private TextField adddepartDate,addarrivingDate;
    @FXML private TableView<Flight> FlightTable;
    @FXML private TableColumn<Flight,String> source,destination,departDate,arrivingDate,duration;
    @FXML private TableColumn<Flight,String> pilot,flightID,airport,terminal,airplane;

    private Stage stage;
    private Scene scene;
    public Parent root;
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
            ArrayList<String> sources = new ArrayList<String>();
            ArrayList<String> destinations = new ArrayList<String>();
            ArrayList<String> terminals = new ArrayList<String>();
            ArrayList<String> pilots = new ArrayList<String>();
            ArrayList<String> airplanes = new ArrayList<String>();

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
                sources.add(rs.getString(2));
                destinations.add(rs.getString(3));
                pilots.add(rs.getString(6));
                airplanes.add(rs.getString(5));
                terminals.add(rs.getString(4));
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
    public void insertDate(Object obj ){
        try{
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            PreparedStatement preparedStatement=null;
            if ((Flight)obj instanceof Flight){
                String sql = "Insert into Flight values(?,?,?,?,?,?,?,?,?,?);";
                int resultSet = 0;
                System.out.print(((Flight) obj).getPilotID());
                System.out.println(((Flight) obj).getFlightID());
                System.out.println(((Flight) obj).duration());
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, ((Flight) obj).getFlightID());
                preparedStatement.setString(2,  ((Flight) obj).getSource());
                preparedStatement.setString(3, ((Flight) obj).getDestination());
                preparedStatement.setString(4, ((Flight) obj).getTerminal());
                preparedStatement.setString(5, ((Flight) obj).getAirplaneID());
                preparedStatement.setInt(6, ((Flight) obj).getPilotID());
                preparedStatement.setString(7, "null");
                preparedStatement.setString(8, ((Flight) obj).getDuration());
                preparedStatement.setString(9, ((Flight) obj).getArrivingDate().toString());
                preparedStatement.setString(10, ((Flight) obj).getDepartDate().toString());
                resultSet=preparedStatement.executeUpdate();
                System.out.println("A new record was inserted successfully!");
                con.close();
                }


        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Inserting Data");
        }}
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
    private void onAddFlight() throws ParseException {
        String source = addsource.getValue().toString();
        String destination = addsource.getValue().toString();
        String arrivingdate = addarrivingDate.getText();
        String departdate = adddepartDate.getText();
        String terminal = addterminal.getValue().toString();
        Integer pilot = Integer.parseInt(add_pilot.getValue().toString());
        String airplane = addairplane.getValue().toString();
        Flight e = new Flight(source,destination,departdate,arrivingdate,terminal,airplane,pilot);

        insertDate(e);
    }

}
