package duke.Command;

import duke.Storage;
import duke.Ui;
import duke.task.TaskList;

import java.io.IOException;

/**
 * Represents list command to be executed. A <code>ListCommand</code> object corresponds to
 * the list command's execution.
 */
public class ListCommand extends Command{
    /**
     * Executes list command
     *
     * @param taskList List of tasks.
     * @param ui Ui object to deal with user interaction.
     * @param storage Storage object to save tasks.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showList(taskList.getData());
    }
}