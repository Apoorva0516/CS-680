package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public class File extends FSElement {
    public File(Directory parent, String name, int size) {
        super(parent, name, size, LocalDateTime.now());
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isFile() {
        return true;
    }

    @Override
    public boolean isLink() {
        return false;
    }
}