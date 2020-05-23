package edu.umb.cs680.hw10.APFS;

public class ApfsCountingVisitor implements ApfsFSVisitor {
    private int dirNum = 0;
    private int fileNum = 0;
    private int linkNum = 0;

    @Override
    public void visit(ApfsLink link) {
        linkNum++;
    }

    @Override
    public void visit(ApfsFile file) {
        fileNum++;
    }

    @Override
    public void visit(ApfsDirectory dir) {
        dirNum++;
    }

    public int getDirNum() {
        return this.dirNum;
    }

    public int getFileNum() {
        return this.fileNum;
    }

    public int getLinkNum() {
        return this.linkNum;
    }
}
