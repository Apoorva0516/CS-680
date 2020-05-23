package edu.umb.cs680.hw06;

public interface State {

    DVDPlayer player = DVDPlayer.getInstance();

    void openClosedButtonPushed();
    void playButtonPushed();
    void stopButtonPushed();
}


