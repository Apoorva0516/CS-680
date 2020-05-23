package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

public class File extends FSElement{
    public File(Directory parent, String name, int size) {
        super(parent, name, size, LocalDateTime.now());
    }

    public boolean isDirectory() {
        return false;
    }
}
