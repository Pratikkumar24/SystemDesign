package CommandDesign.Invoker;

import java.util.Stack;

import CommandDesign.Command.Command;

public class Invoke {
    private Command command;
    private Stack<Command> commandStacks = new Stack<>();

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        commandStacks.add(command);
        command.execute();
    }

    public void undo() {
        if (commandStacks.isEmpty()) {
            System.out.println("No previous data");
            return;
        }
        Command lastCommand = commandStacks.pop();
        lastCommand.undo();
    }
}
