package duke;

import duke.task.Task;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

/**
 * Represents a storage in the local filesystem. A <code>Storage</code> object corresponds to
 * a filePath where data is stored e.g., <code>taskdata.txt</code>
 */

public class Storage {
    public static String filePath;
    protected static ArrayList<String> savedTasks = new ArrayList<>();

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<String> load() throws FileNotFoundException {
        createFileObject(filePath);
        loadFileContents(filePath);
        return savedTasks;
    }

    public void createFileObject(String filePath){
        try {
            File f = new File(filePath);
            f.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Loads tasks from the text file specified in the filePath
     *
     * @param filePath  name of filePath where tasks are saved.
     * @return list of saved tasks.
     * @throws FileNotFoundException  If file is not found
     */
    public ArrayList<String> loadFileContents(String filePath) throws FileNotFoundException {
        File f = new File(filePath); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            savedTasks.add(s.nextLine());
        }
        s.close();
        return savedTasks;
    }

    /**
     * Saves tasks to the textfile specified in the filePath
     *
     * @param tasks  list of tasks.
     * @throws IOException  If there is a file write error
     */
    public void writeToFile(ArrayList<Task> tasks) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        fw.write("");
        fw.close();
        FileWriter fwAppend = new FileWriter(filePath, true);
        for (int i = 0; i < tasks.size(); i++) {
            fwAppend.write((tasks.get(i)).editFile());
        }
        fwAppend.close();
    }
}
