package duke.Command;

import duke.Storage;
import duke.Ui;
import duke.task.TaskList;

import java.io.IOException;

/**
 * Represents exit command to be executed. A <code>ExitCommand</code> object corresponds to
 * the deadline command's execution and exit status.
 */
public class ExitCommand extends Command{

    public ExitCommand() {
        isExit = true;
    }

    /**
     * Executes exit command
     *
     * @param taskList List of tasks.
     * @param ui Ui object to deal with user interaction.
     * @param storage Storage object to save tasks.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showExit();
    }
}
