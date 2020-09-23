package duke.Command;

import duke.Storage;
import duke.Ui;
import duke.task.Task;
import duke.task.TaskList;
import java.util.ArrayList;

public class FindCommand extends Command {

    protected String input;
    public FindCommand(String input) {
        this.input = input;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ArrayList<Task> matchList = taskList.findTask(input);
        ui.showfindList(matchList);
    }

}
