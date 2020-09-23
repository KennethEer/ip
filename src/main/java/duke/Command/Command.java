package duke.Command;

import duke.Storage;
import duke.Ui;
import duke.task.TaskList;
import java.io.IOException;

/**
 * Represents command to be executed. A <code>Command</code> object corresponds to
 * the command's execution and whether it is the bye command
 */
public abstract class Command {

    protected boolean isExit = false;

    /**
     * Executes command
     *
     * @param taskList List of tasks.
     * @param ui Ui object to deal with user interaction.
     * @param storage Storage object to save tasks.
     * @throws IOException If there is an error saving to storage.
     */
    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws IOException;

    /**
     * Returns bye status whether the user types in bye
     *
     * @return exit status
     */
    public boolean isExit() {
        return isExit;
    }

}
