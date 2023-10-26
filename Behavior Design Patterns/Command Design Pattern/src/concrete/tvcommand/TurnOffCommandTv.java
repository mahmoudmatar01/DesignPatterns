package concrete.tvcommand;

import command.Command;
import recivers.Tv;

public class TurnOffCommandTv implements Command {

    private Tv tv;
    public TurnOffCommandTv(Tv tv){
        this.tv=tv;
    }
    @Override
    public void execute() {
        tv.turnOff();
    }

    @Override
    public void undo() {
tv.turnOn();
    }
}
