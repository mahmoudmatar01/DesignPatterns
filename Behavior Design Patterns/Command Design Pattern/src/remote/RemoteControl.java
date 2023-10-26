package remote;

import command.Command;

public class RemoteControl {

    private Command[] onCommands;
    private Command[] offCommands;

    public RemoteControl(){
        onCommands =new Command[4];
        offCommands =new Command[4];
    }

    public void onButtonPressed(int slot){
        onCommands[slot].execute();
    }

    public void offButtonPressed(int slot){
        offCommands[slot].execute();
    }

    public void addCommand(int slot,Command onCommand,Command offCommand){
        onCommands[slot]=onCommand;
        onCommands[slot]=onCommand;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i< onCommands.length;i++){
            stringBuilder.append(String.format("[Slots %d] %s \t %s%n",i,onCommands[i].getClass().getSimpleName(),offCommands[i].getClass().getSimpleName()));
        }
        return stringBuilder.toString();
    }
}
