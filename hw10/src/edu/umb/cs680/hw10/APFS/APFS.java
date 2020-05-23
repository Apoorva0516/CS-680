package edu.umb.cs680.hw10.APFS;

import edu.umb.cs680.hw10.FSFoundation.FSElement;
import edu.umb.cs680.hw10.FSFoundation.FileSystem;

import java.time.LocalDateTime;

public class APFS extends FileSystem {
    private String ownerName;
    private LocalDateTime lastModified;

    public APFS(String ownerName) {
        this.ownerName = ownerName;
        this.lastModified = LocalDateTime.now();
    }

    @Override
    protected FSElement createDefaultRoot() {
        return new ApfsDirectory(null, "root");
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
}
