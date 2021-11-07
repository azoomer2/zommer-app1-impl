/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Alexander Zommer
 */


package baseline;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Item {
    private final StringProperty description;
    private final StringProperty date;

    public Item(){
        this(null,null);
    }

    public Item(String description, String date) {
        this.description = new SimpleStringProperty(description);
        this.date = new SimpleStringProperty(date);
    }

    public void setDate(String dateIn)
    {
        this.date.set(dateIn);
    }

    public void setDescription(String descriptionIn)
    {
        this.description.set(descriptionIn);
    }

    public String getDate()
    {
        return date.get();
    }
    public String getDescription()
    {
        return description.get();
    }
}
