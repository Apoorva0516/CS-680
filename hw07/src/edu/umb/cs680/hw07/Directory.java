package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {
    private LinkedList<FSElement> children;
    public FileSystem fileSystem;

    @Override
    public boolean isDirectory() {
        return true;
    }

    public Directory(Directory parent, String name) {
        super(parent, name, 0, LocalDateTime.now());
        this.children = new LinkedList<>();
        this.fileSystem = FileSystem.getFileSystem();
    }

    public LinkedList<FSElement> getChildren() {
        return this.children;
    }

    public void appendChild(FSElement child) {
        this.children.add(child);
        child.setParent(this);
    }

    public int countChildren() {
        return this.children.size();
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> subDir = new LinkedList<>();
        for (FSElement element: this.children) {
            if (element.isDirectory()) {
                subDir.add((Directory) element);
            }
        }
        return subDir;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<>();
        for (FSElement element: this.children) {
            if (!element.isDirectory()) {
                files.add((File) element);
            }
        }
        return files;
    }

    public int getTotalSize() {
        int totalSize = 0;
        for (FSElement element : this.children) {
            if (element.isDirectory()) {
                Directory subDir = (Directory) element;
                totalSize += subDir.getTotalSize();
            } else {
                totalSize += element.getSize();
            }

        }
        return totalSize;
    }

    public static void main(String args[]) {
        Directory root, applications, home, code;
        File games,music,photos,books,a,b;

        root = new Directory(null, "root");

        applications = new Directory(root, "applications");
        home = new Directory(root, "home");
        root.appendChild(applications);
        root.appendChild((home));

        games = new File(applications, "games", 10);
        music = new File(applications, "music", 10);
        applications.appendChild(games);
        applications.appendChild(music);


        photos = new File(home, "photos", 10);
        books = new File(home, "books", 10);
        code = new Directory(home, "code");
        home.appendChild(photos);
        home.appendChild(books);
        home.appendChild(code);

        a = new File(code, "a", 10);
        b = new File(code, "b", 10);
        code.appendChild(a);
        code.appendChild(b);

        FileSystem.getFileSystem().addRootDir(root);
    }

}























