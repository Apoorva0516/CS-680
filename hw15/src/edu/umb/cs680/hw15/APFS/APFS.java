package edu.umb.cs680.hw15.APFS;

import edu.umb.cs680.hw15.FSFoundation.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class APFS extends FileSystem {
    private String ownerName;
    private LocalDateTime lastModified;

    public APFS(String ownerName) {
        this.ownerName = ownerName;
        this.lastModified = LocalDateTime.now();
    }

    public ApfsDirectory getRootDir() {
        ApfsDirectory rootDir = (ApfsDirectory) this.getRoot();
        return rootDir;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public LocalDateTime getLastModified() {
        return this.lastModified;
    }

    @Override
    protected FSElement createDefaultRoot() {
        return new ApfsDirectory(null, "root");
    }

    public static void main(String args[]) {
        APFS apfs = new APFS( "Rajath");
        apfs.initFileSystem("Local Disk", 1000);
        ApfsDirectory root = (ApfsDirectory) apfs.getRootDir();

        ApfsDirectory applications, home, code;
        ApfsFile games,music,photos,books,a,b;
        ApfsLink x, y;


        applications = new ApfsDirectory(root, "applications");
        home = new ApfsDirectory(root, "home");
        root.appendChild(applications);
        root.appendChild((home));


        games = new ApfsFile(applications, "games", 10);
        music = new ApfsFile(applications, "music", 10);
        applications.appendChild(games);
        applications.appendChild(music);

        photos = new ApfsFile(home, "photos", 10);
        books = new ApfsFile(home, "books", 10);
        code = new ApfsDirectory(home, "code");
        home.appendChild(photos);
        home.appendChild(books);
        home.appendChild(code);

        a = new ApfsFile(code, "a", 10);
        b = new ApfsFile(code, "b", 10);
        code.appendChild(a);
        code.appendChild(b);

        x = new ApfsLink(home, "x", applications);
        y = new ApfsLink(code, "y", music);
        home.appendChild(x);
        code.appendChild(y);
        System.out.println("Root total size: " + root.getTotalSize());
        LinkedList<ApfsElement> rootChildren = root.getChildren();
        for (ApfsElement child : rootChildren) {
            System.out.println(child.getName());
        }
    }
}