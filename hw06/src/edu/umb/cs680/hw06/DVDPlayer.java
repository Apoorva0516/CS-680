package edu.umb.cs680.hw06;

public class DVDPlayer {

    private static DVDPlayer instance = null;
    private static State state;

    private DVDPlayer(State s) {
        state = s;
    }

    private DVDPlayer() {
        state = DrawerClosedNotPlaying.getInstance();
    }

    public static DVDPlayer getInstance() {
        if (instance == null) {

            State s = DrawerClosedNotPlaying.getInstance();
            instance = new DVDPlayer(s);

            instance = new DVDPlayer();
        }

        return instance;
    }

    public void changeState(State s) {
        state = s;
    }

    public void openCloseButtonPushed() {
        state.openClosedButtonPushed();
    }

    public void playButtonPushed() {
        state.playButtonPushed();
    }

    public void stopButtonPushed() {
        state.stopButtonPushed();
    }

    public void open() {
        System.out.println("Open Drawer");
    }

    public void close() {
        System.out.println("Close Drawer");
    }

    public void play() {
        System.out.println("Play DVD");
    }

    public void stop() {
        System.out.println("Stop playing DVD");
    }


    public State getCurrentState() {
        return state;
    }


    public static void main(String args[]) {
        DVDPlayer player = DVDPlayer.getInstance();
        player.openCloseButtonPushed();
        player.playButtonPushed();
        player.stopButtonPushed();
        player.openCloseButtonPushed();
        player.stopButtonPushed();
        player.openCloseButtonPushed();
        player.playButtonPushed();
    }
}
