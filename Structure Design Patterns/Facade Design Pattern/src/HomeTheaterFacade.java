public class HomeTheaterFacade {

    private Projector projector;
    private Amplifier amplifier;
    private PopCornPopper popCornPopper;
    private Screen screen;
    private StreamPlayer streamPlayer;
    private TheaterLights theaterLights;
    private  Tuner tuner;

    public HomeTheaterFacade(){
        projector=new Projector();
        amplifier=new Amplifier();
        popCornPopper=new PopCornPopper();
        screen=new Screen();
        streamPlayer=new StreamPlayer();
        theaterLights=new TheaterLights();
        tuner=new Tuner();
    }

    public void watchMovie(String name){
        popCornPopper.on();
        popCornPopper.pop();
        theaterLights.dim();
        screen.down();
        projector.on();
        projector.wideScreen();
        amplifier.on();
        amplifier.setStreamingPlayer(streamPlayer);
        amplifier.setSurroundSound();
        amplifier.setVolume();
        streamPlayer.on();
        streamPlayer.play(name);
    }

}
