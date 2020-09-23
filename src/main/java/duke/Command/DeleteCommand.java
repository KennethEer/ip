package duke.Command;

import duke.Storage;
import duke.Ui;
import duke.task.Task;
import duke.task.TaskList;

import java.io.IOException;

/**
 * Represents delete command to be executed. A <code>DeleteCommand</code> object corresponds to
 * the delete command's execution.
 */
public class DeleteCommand extends Command{
    protected String input;
    public DeleteCommand(String input) {
        this.input = input;
    }

    /**
     * Executes delete command
     *
     * @param taskList List of tasks.
     * @param ui Ui object to deal with user interaction.
     * @param storage Storage object to save tasks.
     * @throws IOException If there is an error writing to file
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws IOException {
        Task taskToDelete = taskList.deleteTask(input);
        storage.writeToFile(taskList.getData());
        ui.showDeleteTask(taskToDelete, taskList.getData());
    }
}
