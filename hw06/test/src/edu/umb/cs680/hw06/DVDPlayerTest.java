package edu.umb.cs680.hw06;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class DVDPlayerTest {

    @Test
    public void DrawerClosedPlayingTest() {
        DVDPlayer player = DVDPlayer.getInstance();
        player.playButtonPushed();
        assertEquals(DrawerClosedPlaying.getInstance(), player.getCurrentState());
    }

    @Test
    public void DrawerOpenTest() {
        DVDPlayer player = DVDPlayer.getInstance();
        player.playButtonPushed();
        player.openCloseButtonPushed();
        assertEquals(DrawerOpen.getInstance(), player.getCurrentState());
    }

    @Test
    public void DrawerClosedNotPlayingTest() {
        DVDPlayer player = DVDPlayer.getInstance();
        player.playButtonPushed();
        player.stopButtonPushed();
        assertEquals(DrawerClosedNotPlaying.getInstance(), player.getCurrentState());
    }

}