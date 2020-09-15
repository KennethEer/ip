package duke;

import duke.task.Deadline;
import duke.task.Task;
import duke.task.Todo;
import duke.task.Event;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class FileAccess {

    public static void loadData() {
        createFileObject();
        try {
            printFileContents("taskdata.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void createFileObject(){
        try {
            File f = new File("taskdata.txt");
            f.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void printFileContents(String filePath) throws FileNotFoundException {
        File f = new File(filePath); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            System.out.println(s.nextLine());
        }
    }

    public static void readFileContents(String filePath, ArrayList<Task> tasks) throws FileNotFoundException {
        File f = new File(filePath); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            String sentence = s.nextLine();
            if (sentence.contains("T")) {
                tasks.add(new Todo(sentence.substring(7)));
                checkDone(tasks, sentence);
            }
            if (sentence.contains("E")) {
                int slashIndex = sentence.indexOf('|', 7);
                tasks.add(new Event(sentence.substring(8, slashIndex - 1), sentence.substring(slashIndex + 2)));
                checkDone(tasks, sentence);
            }
            if (sentence.contains("D")) {
                int slashIndex = sentence.indexOf('|', 7);
                tasks.add(new Deadline(sentence.substring(8, slashIndex - 1), sentence.substring(slashIndex + 2)));
                checkDone(tasks, sentence);
            }
        }
        s.close();
    }

    private static void checkDone(ArrayList<Task> tasks, String sentence) {
        if (sentence.charAt(4) == '1') {
            (tasks.get(tasks.size()-1)).doTask();
        }
    }

    public static void writeToFile(String filePath, ArrayList<Task> tasks) throws IOException {
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
