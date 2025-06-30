package CommandDesign.Command;

import CommandDesign.Reciever.Light;

public class LightTurnOffCommand implements Command{
    private Light light;
    
    public LightTurnOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOffLight();
    }
    
    @Override
    public void undo() {
        light.turnOnLight();
    }
}
