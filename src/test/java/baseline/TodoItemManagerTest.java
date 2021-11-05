package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemManagerTest {

    @Test
    void addTask() {
        //Take empty list
        //addTask with known date and description
        //assertEquals list with known values
    }

    @Test
    void deleteTask() {
        //Take known list
        //delete an index
        //assertEquals list with known list minus deleted index
    }

    @Test
    void clearList() {
        //take known list
        //clearList()
        //assert that list now equals empty
    }

    @Test
    void markComplete() {
        //take known incomplete list
        //makeComplete(index)
        //verify index is now completed
    }
}