package duke.Command;

import duke.Storage;
import duke.Ui;
import duke.task.Task;
import duke.task.TaskList;

import java.io.IOException;

public class DeleteCommand extends Command{
    protected String input;
    public DeleteCommand(String input) {
        this.input = input;
    }
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws IOException {
        Task taskToDelete = taskList.deleteTask(input);
        storage.writeToFile(taskList.getData());
        ui.showDeleteTask(taskToDelete, taskList.getData());
    }
}
