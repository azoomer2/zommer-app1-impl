/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Alexander Zommer
 */


package baseline;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Item {
    private String description;
    private String date;
    private String complete;

    public Item(String description, String date, String complete)
    {
        this.description = description;
        this.date = date;
        this.complete = complete;
    }

    public Item() {

    }

    public String getComplete() {
        return complete;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }
}
