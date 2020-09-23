package duke.Command;

import duke.Storage;
import duke.Ui;
import duke.task.TaskList;

public class ListCommand extends Command{
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showList(taskList.getData());
    }
}