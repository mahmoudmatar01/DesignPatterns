package concrete.musicplayercommand;

import command.Command;
import recivers.Light;
import recivers.MusicPlayer;

public class TurnOnCommandMusicPlayer implements Command {

    private MusicPlayer musicPlayer;
    public TurnOnCommandMusicPlayer(MusicPlayer musicPlayer){
        this.musicPlayer=musicPlayer;
    }
    @Override
    public void execute() {
        musicPlayer.turnOn();
    }

    @Override
    public void undo() {
        musicPlayer.turnOff();
    }
}
