package duke.Command;

import duke.Storage;
import duke.Ui;
import duke.task.Task;
import duke.task.TaskList;
import java.io.IOException;

public class DoneCommand extends Command {
    protected String input;
    public DoneCommand(String input) {
        this.input = input;
    }
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws IOException {
        Task taskToFinish = taskList.completeTask(input);
        storage.writeToFile(taskList.getData());
        ui.showCompleteTask(taskToFinish);
    }
}
