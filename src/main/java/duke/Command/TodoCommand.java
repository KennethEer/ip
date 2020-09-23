package duke.Command;

import duke.Storage;
import duke.Ui;
import duke.task.Task;
import duke.task.TaskList;
import java.io.IOException;

/**
 * Represents todo command to be executed. A <code>TodoCommand</code> object corresponds to
 * the todo command's execution.
 */
public class TodoCommand extends Command {
    protected String input;

    public TodoCommand(String input) {
        this.input = input;
    }
    /**
     * Executes todo command
     *
     * @param taskList List of tasks.
     * @param ui Ui object to deal with user interaction.
     * @param storage Storage object to save tasks.
     * @throws IOException If there is an error writing to file
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws IOException {
        Task currentTask = null;
        currentTask = taskList.createTodoTask(input);
        if (currentTask != null) {
            (taskList.getData()).add(currentTask);
            storage.writeToFile(taskList.getData());
            ui.showAddTask(currentTask, taskList.getData());
        }
    }
}
