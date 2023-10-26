package concrete.lightcommand;

import command.Command;
import recivers.Light;

public class TurnOnCommandLight implements Command {

    private Light light;
    public TurnOnCommandLight(Light light){
        this.light=light;
    }
    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
light.turnOff();
    }
}
