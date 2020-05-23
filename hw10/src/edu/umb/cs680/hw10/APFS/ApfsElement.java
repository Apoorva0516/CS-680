package edu.umb.cs680.hw10.APFS;

import edu.umb.cs680.hw10.FSFoundation.FSElement;

import java.time.LocalDateTime;

public abstract class ApfsElement extends FSElement {
    private LocalDateTime creationTime;
    private LocalDateTime lastModified;

    protected ApfsDirectory parent;

    public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
        super(name, size);
        this.parent = parent;
        this.creationTime = creationTime;
    }

    public ApfsDirectory getParent() {
        return this.parent;
    }

    public abstract boolean isLink();

    public void setParent(ApfsDirectory parent) {
        this.parent = parent;
    }

    public int getSize() {
        return this.size;
    }

    public String getName() {
        return this.name;
    }

    public LocalDateTime getCreationTime() {
        return this.creationTime;
    }

    public abstract void accept(ApfsFSVisitor v);

    public LocalDateTime getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(LocalDateTime time) {
        this.lastModified = time;
    }
}
