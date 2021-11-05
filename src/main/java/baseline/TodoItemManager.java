/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Alexander Zommer
 */
package baseline;

public class TodoItemManager {


    public void addTask(String date, String task, String description)
    {
        //Pull date and description fields
        //Put date and descriptions into lists
        //Pull from lists to update tableview
    }
    public void deleteTask(int index)
    {
        //Pull the selected task index from the list
        //Delete the selected index from the list
    }
    public void clearList()
    {
        //delete all indexes from list
    }
    public void markComplete(int index)
    {
        //pull the index from the selected task
        //make the selected task a different color?
    }
    private void displayAll()
    {
        //send all indices of list to tableview
    }
    private void displayComplete()
    {
        //send only completed items to tableview
    }
    private void displayIncomplete()
    {
        //send only incomplete items to tableview
    }
    private void saveList()
    {
        //save list to local hd
    }
    private void loadList()
    {
        //load list from local hd
    }


    //EDITING OF DESCRIPTION CAN BE DONE DIRECTLY IN THE TO DO LIST TABLE

}
