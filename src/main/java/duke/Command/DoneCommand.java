package duke.Command;

import duke.Storage;
import duke.Ui;
import duke.task.Task;
import duke.task.TaskList;
import java.io.IOException;

/**
 * Represents done command to be executed. A <code>DoneCommand</code> object corresponds to
 * the done command's execution.
 */
public class DoneCommand extends Command {
    protected String input;
    public DoneCommand(String input) {
        this.input = input;
    }
    /**
     * Executes done command
     *
     * @param taskList List of tasks.
     * @param ui Ui object to deal with user interaction.
     * @param storage Storage object to save tasks.
     * @throws IOException If there is an error writing to file
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws IOException {
        Task taskToFinish = taskList.completeTask(input);
        storage.writeToFile(taskList.getData());
        ui.showCompleteTask(taskToFinish);
    }
}
