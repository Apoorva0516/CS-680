package edu.umb.cs680.hw06;

public class DrawerClosedPlaying implements State {

    private static DVDPlayer player = DVDPlayer.getInstance();

    private DrawerClosedPlaying() {}

    private static DrawerClosedPlaying instance = null;

    public static DrawerClosedPlaying getInstance() {
        if (instance == null)
            instance = new DrawerClosedPlaying();
        return instance;
    }

    @Override
    public void openClosedButtonPushed() {
        player.stop();
        player.open();
        player.changeState(DrawerOpen.getInstance());
    }

    @Override
    public void playButtonPushed() {
        System.out.println("Do nothing");
    }

    @Override
    public void stopButtonPushed() {
        player.stop();
        player.changeState(DrawerClosedNotPlaying.getInstance());
    }
}