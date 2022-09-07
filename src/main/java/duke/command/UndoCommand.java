package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class UndoCommand extends Command {
    private TaskList prevTaskList;

    /**
     * Constructor for UndoCommand.
     * @param prevTaskList TaskList prior to the previous command.
     */
    public UndoCommand(TaskList prevTaskList) {
        this.prevTaskList = prevTaskList;
    }

    /**
     * Updates storage with the previous TaskList.
     * @param list TaskList containing the list of tasks.
     * @param storage Storage that loads and saves to the save file.
     * @return toString of keyword TaskList.
     */
    @Override
    public String execute(TaskList list, Storage storage) {
        storage.writeToFile(this.prevTaskList);
        return Ui.undoMessage();
    }
}
