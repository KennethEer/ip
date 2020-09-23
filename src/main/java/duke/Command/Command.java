package duke.Command;

import duke.Storage;
import duke.Ui;
import duke.task.TaskList;
import java.io.IOException;

public abstract class Command {

    protected boolean isExit = false;

    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws IOException;

    public boolean isExit() {
        return isExit;
    }

}
