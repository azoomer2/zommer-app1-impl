package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TodoListManagerTest {

    TodoListManager lm = new TodoListManager();

    @Test
    void addTask() {
        ObservableList<Item> known = FXCollections.observableArrayList();
        //addTask with known date and description
        known.add(new Item("test","2021-11-07","y"));
        lm.clearList();
        lm.addTask("test","2021-11-07","y");
        //assertEquals list with known values

        assertEquals(lm.list.get(0).getDescription(),known.get(0).getDescription());
        assertEquals(lm.list.get(0).getDate(),known.get(0).getDate());
        assertEquals(lm.list.get(0).getComplete(),known.get(0).getComplete());
    }

    @Test
    void deleteTask() {
        ObservableList<Item> known = FXCollections.observableArrayList();
        //Take known list
        lm.addTask("test","2021-11-07","y");
        //delete an index
        lm.deleteTask(lm.list.get(0));
        //assertEquals list with known list minus deleted index
        assertEquals(known,lm.list);
    }

    @Test
    void clearList() {
        //take known list
        ObservableList<Item> known = FXCollections.observableArrayList();
        //clearList()
        lm.addTask("test","2021-11-07","y");
        lm.clearList();
        //assert that list now equals empty
        assertEquals(known,lm.list);
    }


    @Test
    void saveList() throws IOException {
        lm.saveList("./docs/junitTest");
        File file = new File("./docs/junitTest.txt");
        assertTrue(file.exists());
    }
}