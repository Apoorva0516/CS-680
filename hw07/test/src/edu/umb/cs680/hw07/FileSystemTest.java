package edu.umb.cs680.hw07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileSystemTest {
    private static Directory root, applications, home, code;
    private static File a, b, c, d, e, f;

    @BeforeAll
    public static void setUp() {
        root = new Directory(null, "root");

        applications = new Directory(root, "applications");
        home = new Directory(root, "home");
        root.appendChild(applications);
        root.appendChild((home));

        a = new File(applications, "a", 10);
        b = new File(applications, "b", 10);
        applications.appendChild(a);
        applications.appendChild(b);


        c = new File(home, "c", 10);
        d = new File(home, "d", 10);
        code = new Directory(home, "code");
        home.appendChild(c);
        home.appendChild(d);
        home.appendChild(code);

        e = new File(code, "e", 10);
        f = new File(code, "f", 10);
        code.appendChild(e);
        code.appendChild(f);
    }

    @Test
    public void getRootDirsOfFileSystem() {
        FileSystem.getFileSystem().addRootDir(root);

        LinkedList<Directory> expected = new LinkedList<>(Arrays.asList(root));
        LinkedList<Directory> actual = FileSystem.getFileSystem().getRootDirs();
        assertEquals(expected, actual);
    }
}