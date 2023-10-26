package concrete.musicplayercommand;

import command.Command;
import recivers.MusicPlayer;

public class TurnOffCommandMusicPlayer implements Command {

    private MusicPlayer musicPlayer;
    public TurnOffCommandMusicPlayer(MusicPlayer musicPlayer){
        this.musicPlayer=musicPlayer;
    }
    @Override
    public void execute() {
        musicPlayer.turnOff();
    }

    @Override
    public void undo() {
        musicPlayer.turnOn();
    }
}
