/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Alexander Zommer
 */


package baseline;

import javafx.beans.property.SimpleStringProperty;

public class Item {
    private final String description = "";
    private final String date = "None";

    public Item(String description, String date) {
        //setDescription(description);
        //setDate(date);
    }

    public void setDate(String dateIn)
    {
        //date.set(dateIn);
    }

    public void setDescription(String descriptionIn)
    {
        //description.set(descriptionIn);
    }

    public String getDate()
    {
        return date;
    }
    public String getDescription()
    {
        return description;
    }
}
