/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Alexander Zommer
 */


package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class TodoListApplication extends javafx.application.Application {

    private ObservableList<Item> itemData = FXCollections.observableArrayList();


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Application.fxml"));

        TableView tableView = new TableView();

        TableColumn<Item,String> desColumn = new TableColumn<>("Description");
        desColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Item,String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        tableView.getColumns().add(desColumn);
        tableView.getColumns().add(dateColumn);

        tableView.getItems().add(new Item("Mow Grass","2021-11-08"));



        Scene scene = new Scene(root); // attach scene graph to scene
        stage.setTitle("ToDo List"); // displayed in window's title bar
        stage.setScene(scene); // attach scene to stage
        stage.show(); // display the stage
    }

    ApplicationController test = new ApplicationController();
    @FXML
    void addItem(ActionEvent event) {


    }

    @FXML
    void clearList(ActionEvent event) {

    }

    @FXML
    void deleteItem(ActionEvent event) {

    }



}

