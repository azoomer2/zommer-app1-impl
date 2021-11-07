/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Alexander Zommer
 */
package baseline;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;



public class ApplicationController implements Initializable {

        private LocalDate dateInput;
        private String descriptionInput;

        TodoItemManager action = new TodoItemManager();

        @FXML
        private Button addButton;

        @FXML
        private Button clearButton;

        @FXML
        private TableColumn<?, ?> completed;

        @FXML
        private TableView<?> dataTable;

        @FXML
        private TableColumn<?, ?> date;

        @FXML
        private Button deleteButton;

        @FXML
        private TableColumn<?, ?> description;

        @FXML
        private TextField descriptionField;

        @FXML
        private DatePicker dueDateField;

        @FXML
        private Menu file;

        @FXML
        void addItem(ActionEvent event) {
                String dateStr;

                descriptionInput = descriptionField.getText();
                dateInput = dueDateField.getValue();
                if(dateInput != null)
                {
                        dateStr = dateInput.toString();
                }

                else
                {
                       dateStr = "None";
                }

                action.addTask(dateStr,descriptionInput);
                descriptionInput = null;
                dateInput = null;
        }

        @FXML
        void clearList(ActionEvent event) {

        }

        @FXML
        void deleteItem(ActionEvent event) {

        }






        @Override
        public void initialize(URL url, ResourceBundle rb)
        {
                addButton.setOnAction(this::addItem);
        }



}
