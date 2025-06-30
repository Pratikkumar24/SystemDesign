package CommandDesign;

import CommandDesign.Command.LightTurnOnCommand;
import CommandDesign.Invoker.Invoke;
import CommandDesign.Reciever.Light;

public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Invoke invoke = new Invoke();

        invoke.setCommand(new LightTurnOnCommand(light));

        invoke.pressButton();
        invoke.pressButton();
        invoke.undo();
        invoke.undo();
        invoke.undo();
    }
}
