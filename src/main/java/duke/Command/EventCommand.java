package duke.Command;

import duke.Storage;
import duke.Ui;
import duke.task.Task;
import duke.task.TaskList;
import java.io.IOException;

/**
 * Represents event command to be executed. A <code>EventCommand</code> object corresponds to
 * the event command's execution.
 */
public class EventCommand extends Command {
    protected String input;
    public EventCommand(String input) {
        this.input = input;
    }

    /**
     * Executes event command
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
        currentTask = taskList.createEventTask(input, slashIndex);
        if (currentTask != null) {
            (taskList.getData()).add(currentTask);
            storage.writeToFile(taskList.getData());
            ui.showAddTask(currentTask, taskList.getData());
        }
    }
}
