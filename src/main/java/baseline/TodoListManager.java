/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Alexander Zommer
 */
package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.stage.StageStyle;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TodoListManager {



    ObservableList<Item> list = FXCollections.observableArrayList(
            //new Item("Mow lawn","2021-11-08","n"),
            //new Item("cry","forever", "n")
    );
    FilteredList<Item> filteredList = new FilteredList<>(list,p->true);

    public ObservableList<Item> getList()
    {
        return this.filteredList;
    }

    public void addTask(String date, String description, String complete)
    {
        description = description.substring(0, Math.min(description.length(),256));


        list.add(new Item(description,date,complete));
    }
    public void deleteTask(Item index)
    {
        list.remove(index);
        //Delete the selected index from the list
    }
    public void clearList()
    {
        //delete all indexes from list
        list.clear();
    }

    public void saveList( String path) throws IOException {

        FileWriter writer = null;
        writer = new FileWriter(path+".txt");

        FileWriter finalWriter = writer;
        list.forEach(Item -> {
            try {
                finalWriter.write(Item.getDescription()+",");
                finalWriter.write(Item.getDate()+",");
                finalWriter.write(Item.getComplete()+",");
                finalWriter.write("\n");

            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        finalWriter.close();

    }
    public void loadList(String path) throws IOException {
        clearList();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = null;


        while ((line = br.readLine()) != null) {
            String[] values = line.split("\n");

            for (String str : values) {
                listLoader(str);
            }
        }
        br.close();
    }

    private void listLoader(String str) {
        ArrayList<String> tempList = new ArrayList<>(Arrays.asList(str.split(",")));
        list.add(new Item(tempList.get(0),tempList.get(1), tempList.get(2)));
    }
}





    //EDITING OF DESCRIPTION CAN BE DONE DIRECTLY IN THE TO DO LIST TABLE


