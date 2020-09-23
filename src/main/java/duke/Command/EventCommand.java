package duke.Command;

import duke.Storage;
import duke.Ui;
import duke.task.Task;
import duke.task.TaskList;
import java.io.IOException;

public class EventCommand extends Command{
    protected String input;
    public EventCommand(String input) {
        this.input = input;
    }
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
