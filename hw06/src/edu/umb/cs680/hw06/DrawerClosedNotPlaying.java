package edu.umb.cs680.hw06;

public class DrawerClosedNotPlaying implements State {

    private static DVDPlayer player = DVDPlayer.getInstance();

    private DrawerClosedNotPlaying() {}

    private static DrawerClosedNotPlaying instance = null;

    public static DrawerClosedNotPlaying getInstance() {
        if (instance == null)
            instance = new DrawerClosedNotPlaying();
        return instance;
    }

    @Override
    public void openClosedButtonPushed() {
        player.open();
        player.changeState(DrawerOpen.getInstance());
    }

    @Override
    public void playButtonPushed() {
        player.play();
        player.changeState(DrawerClosedPlaying.getInstance());
    }

    @Override
    public void stopButtonPushed() {
        System.out.println("Do nothing");
    }
}