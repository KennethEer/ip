package duke.task;

import duke.DukeException;
import duke.Ui;
import java.util.ArrayList;

/**
 * Represents a task list. A <code>TaskList</code> object corresponds to
 * a list of tasks and a Ui object
 */
public class TaskList {
    public Ui ui = new Ui();

    public ArrayList<Task> taskList;

    private int endIndexOfDescription;
    private int startIndexOfWhen;
    private static final int DEADLINE_CHAR = 9; //number of characters in "deadline "
    private static final int EVENT_CHAR = 6;  //number of characters in "event "
    private static final int TODO_CHAR = 5;  //number of characters in "todo "
    private static final int DONE_CHAR = 5;  //number of characters in "done "
    private static final int DELETE_CHAR = 7;  //number of characters in "delete "
    private static final int FIND_CHAR = 5;  //number of characters in "find "

    public TaskList() {
        taskList = new ArrayList<>();
    }

    public TaskList(ArrayList<String> savedTasks) {
        taskList = readFileContents(savedTasks);
    }

    /**
     * Returns the list of tasks.
     *
     * @return list of tasks.
     */
    public ArrayList<Task> getData() {
        return taskList;
    }

    /**
     * Reads the list of saved tasks and add to the list of tasks.
     *
     *
     * @param savedTasks list of saved tasks
     * @return list of tasks.
     */
    public ArrayList<Task> readFileContents(ArrayList<String> savedTasks) {
        taskList = new ArrayList<>();
        for (int i = 0; i < savedTasks.size(); i++) {
            String sentence = savedTasks.get(i);
            if (sentence.startsWith("T")) {
                taskList.add(new Todo(sentence.substring(7)));
            }
            if (sentence.startsWith("E")) {
                int slashIndex = sentence.indexOf('|', 7);
                taskList.add(new Event(sentence.substring(8, slashIndex - 1), sentence.substring(slashIndex + 2)));
            }
            if (sentence.startsWith("D")) {
                int slashIndex = sentence.indexOf('|', 7);
                taskList.add(new Deadline(sentence.substring(8, slashIndex - 1), sentence.substring(slashIndex + 2)));
            }
            checkDone(sentence);
        }
        return taskList;
    }
    /**
     * Checks if the task is done and change done status of task
     *
     * @param sentence sentence from saved file.
     */
    private void checkDone(String sentence) {
        if (sentence.charAt(4) == '1') {
            (taskList.get(taskList.size()-1)).doTask();
        }
    }

    private void getIndex(int slashIndex) {
        endIndexOfDescription = slashIndex - 1;
        startIndexOfWhen = slashIndex + 4;
    }

    /**
     * Checks if the user input is valid
     *
     * @param input input typed in by user
     * @param slashIndex index of slash in user input
     * @return user input validity status
     */

    private boolean checkValid(String input, int slashIndex) {
        getIndex(slashIndex);
        boolean hasAt = input.contains(" /at ");
        boolean hasBy = input.contains(" /by ");
        boolean exceedLength = startIndexOfWhen >= input.length();
        boolean hasDeadlineTask = endIndexOfDescription >= DEADLINE_CHAR;
        boolean hasEventTask = endIndexOfDescription >= EVENT_CHAR;

        if (input.contains("deadline")) {
            if (!hasBy || exceedLength || !hasDeadlineTask) {
                return false;
            }
        } else if (input.contains("event")) {
            if (!hasAt || exceedLength || !hasEventTask) {
                return false;
            }
        }
        return true;
    }

    /**
     * Creates a deadline task
     *
     * @param input input typed in by user
     * @param slashIndex index of slash in user input
     * @return deadline task that is created
     * @throws DukeException  If user input is invalid.
     */
    public Task createDeadlineTask(String input, int slashIndex){
        getIndex(slashIndex);
        try {
            if (checkValid(input, slashIndex)) {
                return new Deadline(input.substring(DEADLINE_CHAR, endIndexOfDescription), input.substring(startIndexOfWhen));
            } else if (input.trim().equals("deadline")) {
                throw new DukeException("deadline");
            } else {
                throw new DukeException(input);
            }
        } catch (DukeException e) {
            ui.showError(e.getErrorMessage());
        }
        return null;
    }

    /**
     * Creates an event task
     *
     * @param input input typed in by user
     * @param slashIndex index of slash in user input
     * @return event task that is created
     * @throws DukeException  If user input is invalid.
     */
    public Task createEventTask(String input, int slashIndex) {
        try {
            if (checkValid(input, slashIndex)) {
                return new Event(input.substring(EVENT_CHAR, endIndexOfDescription), input.substring(startIndexOfWhen));
            } else if (input.trim().equals("event")) {
                throw new DukeException("event");
            } else {
                throw new DukeException(input);
            }
        } catch (DukeException e) {
            ui.showError(e.getErrorMessage());
        }
        return null;
    }

    /**
     * Creates a todo task
     *
     * @param input input typed in by user
     * @return todo task that is created
     * @throws DukeException  If user input is invalid.
     */
    public Task createTodoTask(String input) {
        try {
            if (input.substring(TODO_CHAR).isBlank()) {
                throw new DukeException("todo");
            } else {
                return new Todo(input.substring(TODO_CHAR));
            }
        } catch (DukeException e) {
            ui.showError(e.getErrorMessage());
        }
        return null;
    }

    /**
     * Completes task
     *
     * @param input input typed in by user
     * @return task that is completed
     * @throws NumberFormatException  If user input is invalid.
     */
    public Task completeTask(String input) throws NumberFormatException {
        Task taskToFinish = null;
        if (input.length() <= DONE_CHAR) {
            System.out.println("Please input done and and a blank space and task number");
            return null;
        }
        String taskDigit = input.substring(DONE_CHAR);
        try {
            int taskNumber = Integer.parseInt(taskDigit);
            if (!(taskNumber >= 0 && taskNumber <= taskList.size())) {
                System.out.println("This task number is invalid. Please try again.");
                return null;
            }
            taskToFinish = taskList.get(taskNumber - 1);
            taskToFinish.doTask();
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        return taskToFinish;
    }

    /**
     * Deletes task
     *
     * @param input input typed in by user
     * @return task that is deleted
     * @throws NumberFormatException  If user input is invalid.
     */
    public Task deleteTask(String input) {
        Task taskToDelete = null;
        if (input.length() <= DELETE_CHAR) {
            System.out.println("Please input delete and a blank space and task number");
            return null;
        }
        String taskDigit = input.substring(DELETE_CHAR);
        try {
            int taskNumber = Integer.parseInt(taskDigit);
            if (taskNumber > taskList.size() || taskNumber <= 0) {
                System.out.println("This task number is invalid. Please try again.");
                return null;
            } else {
                taskToDelete = taskList.get(taskNumber - 1);
                taskList.remove(taskNumber - 1);
            }
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        return taskToDelete;
    }

    public ArrayList<Task> findTask(String input) {
        ArrayList<Task> matchList = new ArrayList<>();
        String findTask = input.substring(FIND_CHAR);
        for (int i = 0; i < taskList.size(); i++) {
            if ((taskList.get(i)).findInput(findTask)) {
                 matchList.add(taskList.get(i));
            }
        }
        return matchList;
    }
}

