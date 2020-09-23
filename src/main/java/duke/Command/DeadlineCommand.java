package duke.Command;

import duke.Storage;
import duke.Ui;
import duke.task.Task;
import duke.task.TaskList;

import java.io.IOException;

/**
 * Represents deadline command to be executed. A <code>DeadlineCommand</code> object corresponds to
 * the deadline command's execution.
 */
public class DeadlineCommand extends Command {
    protected String input;

    public DeadlineCommand(String input) {
        this.input = input;
    }

    /**
     * Executes deadline command
     *
     * @param taskList List of tasks.
     * @param ui Ui object to deal with user interaction.
     * @param storage Storage object to save tasks.
     * @throws IOException If there is an error writing to file
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws IOException {
        int slashIndex = input.indexOf('/');
        Task currentTask = null;
        currentTask = taskList.createDeadlineTask(input, slashIndex);
        if (currentTask != null) {
            (taskList.getData()).add(currentTask);
            storage.writeToFile(taskList.getData());
            ui.showAddTask(currentTask, taskList.getData());
        }
    }
}