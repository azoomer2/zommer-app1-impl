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

        Scene scene = new Scene(root); // attach scene graph to scene
        stage.setTitle("ToDo List"); // displayed in window's title bar
        stage.setScene(scene); // attach scene to stage
        stage.show(); // display the stage
    }


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

