package concrete.lightcommand;

import command.Command;
import recivers.Light;

public class TurnOffCommandLight implements Command {

    private Light light;
    public TurnOffCommandLight(Light light){
        this.light=light;
    }
    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
light.turnOn();
    }
}
