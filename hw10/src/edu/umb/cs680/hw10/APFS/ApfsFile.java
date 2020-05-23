package edu.umb.cs680.hw10.APFS;

import java.time.LocalDateTime;

public class ApfsFile extends ApfsElement {
    public ApfsFile(ApfsDirectory parent, String name, int size) {
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

    @Override
    public void accept(ApfsFSVisitor v) {
        v.visit(this);
    }
}
