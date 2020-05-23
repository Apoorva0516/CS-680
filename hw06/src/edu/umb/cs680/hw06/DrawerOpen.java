package edu.umb.cs680.hw06;

public class DrawerOpen implements State {

	private static DVDPlayer player = DVDPlayer.getInstance();
    private DrawerOpen() {}

    private static DrawerOpen instance = null;

    public static DrawerOpen getInstance() {
        if (instance == null)
            instance = new DrawerOpen();
        return instance;
    }

    @Override
    public void openClosedButtonPushed() {
        player.close();
        player.changeState(DrawerClosedNotPlaying.getInstance());
    }

    @Override
    public void playButtonPushed() {
        player.close();
        player.play();
        player.changeState(DrawerClosedPlaying.getInstance());
    }

    @Override
    public void stopButtonPushed() {
        System.out.println("Do nothing");
    }
}