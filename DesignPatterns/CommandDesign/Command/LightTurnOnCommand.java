package CommandDesign.Command;

import CommandDesign.Reciever.Light;

public class LightTurnOnCommand implements Command{
    private Light light;

    public LightTurnOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOnLight();
    }
 
    @Override
    public void undo() {
        light.turnOffLight();
    }
}
