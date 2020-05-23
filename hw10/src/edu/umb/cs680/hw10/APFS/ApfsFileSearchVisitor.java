package edu.umb.cs680.hw10.APFS;

import java.util.LinkedList;

public class ApfsFileSearchVisitor implements ApfsFSVisitor {
    private String fileName;
    private LinkedList<ApfsFile> foundFiles = new LinkedList<>();

    public ApfsFileSearchVisitor(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void visit(ApfsDirectory dir) {
        return;
    }

    @Override
    public void visit(ApfsLink link) {
        return;
    }

    @Override
    public void visit(ApfsFile file) {
        if (file.getName().equals(this.fileName)) {
            foundFiles.add(file);
        }
    }

    public LinkedList<ApfsFile> getFoundFiles() {
        return this.foundFiles;
    }
}
