package edu.umb.cs680.hw10.APFS;

public interface ApfsFSVisitor {
    void visit(ApfsLink link);
    void visit(ApfsDirectory dir);
    void visit(ApfsFile file);
}
