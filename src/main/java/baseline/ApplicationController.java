/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Alexander Zommer
 */
package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.InputMethodEvent;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;



public class ApplicationController implements Initializable {

         String dateInput;

         String completeInput;

        TodoListManager listMan = new TodoListManager();

        ObservableList<String> choiceBoxOptions = FXCollections.observableArrayList("All","Complete","Incomplete");

        @FXML
        private Button addButton;

        @FXML
        private Button clearButton;

        @FXML
        private TableColumn<Item, String> completed;

        @FXML
        private TableView<Item> dataTable;

        @FXML
        private TableColumn<Item, String> date;

        @FXML
        private Button deleteButton;

        @FXML
        private TableColumn<Item, String> description;

        @FXML
        private TextField descriptionField;

        @FXML
        private DatePicker dueDateField;

        @FXML
        private Menu file;

        @FXML
        private MenuItem loadButton;

        @FXML
        private MenuItem saveButton;

        @FXML
        private ChoiceBox<String> choiceBox;

        @FXML
        void addItem(ActionEvent event) {
                String descIn = descriptionField.getText();
                LocalDate dateIn = dueDateField.getValue();
                completeInput = "n";
                if(dateIn != null)
                {
                        dateInput = dateIn.toString();
                }
                else
                        dateInput = "none";

                if(descIn == "")
                        descIn = "No description provided";

                listMan.addTask(descIn,dateInput,completeInput);
                descriptionField.clear();
                dueDateField.setValue(null);
        }

        @FXML
        void clearList(ActionEvent event) {
                listMan.clearList();
        }

        @FXML
        void deleteItem(ActionEvent event) {
                Item delete = dataTable.getSelectionModel().getSelectedItem();
                System.out.println(dataTable.getSelectionModel().getSelectedItem());
                listMan.deleteTask(delete);
        }
        @FXML
        void filterChange(InputMethodEvent event) {
                //Unused In final code
        }


        @Override
        public void initialize(URL url, ResourceBundle rb)
        {
                initTable();
                initChoiceBox();

        }

        private void initTable()
        {
                initCols();
        }

        private void initCols()
        {

                description.setCellValueFactory(new PropertyValueFactory<>("description"));
                date.setCellValueFactory(new PropertyValueFactory<>("date"));
                completed.setCellValueFactory(new PropertyValueFactory<>("complete"));

                editableCols();

                dataTable.setItems(listMan.getList());
        }

        private void editableCols()
        {

                description.setCellFactory(TextFieldTableCell.forTableColumn());
                description.setOnEditCommit(e->
                        e.getTableView().getItems().get(e.getTablePosition().getRow()).setDescription(e.getNewValue()));

                date.setCellFactory(TextFieldTableCell.forTableColumn());
                date.setOnEditCommit(e->
                        e.getTableView().getItems().get(e.getTablePosition().getRow()).setDate(e.getNewValue()));

                completed.setCellFactory(TextFieldTableCell.forTableColumn());
                completed.setOnEditCommit(e->
                        e.getTableView().getItems().get(e.getTablePosition().getRow()).setComplete(e.getNewValue()));

                dataTable.setEditable(true);
        }

        private void initChoiceBox()
        {

                choiceBox.setItems(choiceBoxOptions);
                choiceBox.setValue("All");

                choiceBox.valueProperty().addListener((observable, oldValue, newValue) -> listMan.filteredList.setPredicate(Item->{
                                if(newValue.equals("All")|| newValue.isEmpty()) {
                                        return true;
                                }

                                else if (newValue.equals("Complete"))
                                {
                                        return Item.getComplete().equals("y") || Item.getComplete().equals("Y");
                                }

                                else
                                {
                                        return !Item.getComplete().equals("y") && !Item.getComplete().equals("Y");
                                }
                        }));
                        dataTable.setItems(listMan.getList());





        }
        @FXML
        void load(ActionEvent event) throws IOException {
                JButton load = new JButton();
                JFileChooser fc = new JFileChooser();
                fc.setCurrentDirectory(new java.io.File(""));
                fc.setDialogTitle("Save List");
                if(fc.showOpenDialog(load) == JFileChooser.APPROVE_OPTION){
                        System.out.println("Successfully Loaded");
                }
                String path = fc.getSelectedFile().getPath();

                listMan.loadList(path);

        }

        @FXML
        void save(ActionEvent event) throws IOException {

                JButton save = new JButton();
                JFileChooser fc = new JFileChooser();
                fc.setCurrentDirectory(new java.io.File(""));
                fc.setDialogTitle("Save List");
                if(fc.showSaveDialog(save) == JFileChooser.APPROVE_OPTION){
                        System.out.println("Successfully Saved");
                }
                String path = fc.getSelectedFile().getPath();

                listMan.saveList(path);
        }

}
