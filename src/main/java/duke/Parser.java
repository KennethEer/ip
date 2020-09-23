package duke;

import duke.Command.Command;
import duke.Command.DeadlineCommand;
import duke.Command.DeleteCommand;
import duke.Command.DoneCommand;
import duke.Command.EventCommand;
import duke.Command.ExitCommand;
import duke.Command.ListCommand;
import duke.Command.TodoCommand;

public class Parser {
    public static boolean isExit = false;
    public static Command parse(String input) throws DukeException {
        Command command = createCommand(input);
        return command;
    }

    private static Command createCommand(String input) throws DukeException {
        Command command;
        if (input.equals("list")) {
            command = new ListCommand();
        } else if (input.startsWith("done ")) {
            command = new DoneCommand(input);
        } else if (input.startsWith("delete ")) {
            command = new DeleteCommand(input);
        } else if (input.equals("bye")) {
            command = new ExitCommand();
        } else if (input.startsWith("deadline ")) {
            command = new DeadlineCommand(input);
        } else if (input.startsWith("event ")) {
            command = new EventCommand(input);
        } else if (input.startsWith("todo ")) {
            command = new TodoCommand(input);
        } else {
            throw new DukeException(input);
        }
        return command;
    }
}


