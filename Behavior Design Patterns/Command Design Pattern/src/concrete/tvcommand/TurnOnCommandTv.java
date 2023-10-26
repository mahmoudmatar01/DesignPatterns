package concrete.tvcommand;

import command.Command;
import recivers.Tv;

public class TurnOnCommandTv implements Command {

    private Tv tv;
    public TurnOnCommandTv(Tv tv){
        this.tv=tv;
    }
    @Override
    public void execute() {
        tv.turnOn();
    }

    @Override
    public void undo() {
tv.turnOff();
    }
}
