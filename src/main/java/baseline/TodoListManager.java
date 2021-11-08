/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Alexander Zommer
 */
package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TodoListManager {


    //create empty observable list
    ObservableList<Item> list = FXCollections.observableArrayList();
    //wrap observable list in filtered list
    FilteredList<Item> filteredList = new FilteredList<>(list,p->true);

    public ObservableList<Item> getList()
    {
        //return list
        return this.filteredList;
    }

    public void addTask(String description, String date,  String complete)
    {
        //trim description if longer than 256
        description = description.substring(0, Math.min(description.length(),256));

        //.add new observable list item
        list.add(new Item(description,date,complete));
    }
    public void deleteTask(Item index)
    {
        //Delete the selected index from the list
        list.remove(index);
    }
    public void clearList()
    {
        //delete all indexes from list
        list.clear();
    }

    public void saveList( String path) throws IOException {
        //Open new file at path from file
        FileWriter writer;
        writer = new FileWriter(path+".txt");

        FileWriter finalWriter = writer;
        //write pseudo comma delineated file out to path
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
        //clear out old list to make room for new
        clearList();
        //new buffered reader to read in pseudo comma delineated save file
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            //read in each line of loaded file and call reader function
            while ((line = br.readLine()) != null) {
                String[] values = line.split("\n");

                for (String str : values) {
                    listLoader(str);
                }
            }
        }

    }

    private void listLoader(String str) {
        //.split up the line read String by ",", add to new list
        ArrayList<String> tempList = new ArrayList<>(Arrays.asList(str.split(",")));
        addTask(tempList.get(0),tempList.get(1), tempList.get(2));
    }
}



