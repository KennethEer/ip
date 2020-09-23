package duke;

import duke.Command.Command;
import duke.Command.DeadlineCommand;
import duke.Command.DeleteCommand;
import duke.Command.DoneCommand;
import duke.Command.EventCommand;
import duke.Command.ExitCommand;
import duke.Command.ListCommand;
import duke.Command.TodoCommand;

/**
 * Represents a parser that deals with making sense of the user command
 */
public class Parser {
    public static boolean isExit = false;

    /**
     * Returns command object from parsing an input message.
     *
     * @param input input typed by user.
     * @return command to be executed.
     */
    public static Command parse(String input) throws DukeException {
        Command command = createCommand(input);
        return command;
    }

    /**
     * Creates command object based on user's input.
     *
     * @param input input typed by user.
     * @return command that is created.
     */
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


