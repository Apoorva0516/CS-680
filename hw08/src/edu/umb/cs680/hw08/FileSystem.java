package edu.umb.cs680.hw08;

import java.util.LinkedList;

public class FileSystem {
    private static FileSystem instance = null;
    private LinkedList<Directory> rootDirs = new LinkedList<>();

    private FileSystem() {}

    public static FileSystem getFileSystem() {
        if (instance == null) {
            instance = new FileSystem();
        }
        return instance;
    }

    public LinkedList<Directory> getRootDirs() {
        return this.rootDirs;
    }

    public void addRootDir(Directory rootDir) {
        this.rootDirs.add(rootDir);
    }
} 