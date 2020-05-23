package edu.umb.cs680.hw08;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileSystemTest {
    private static Directory root, applications, home, code;
    private static File games, music, photos, books, a, b;
    private static Link x, y;

    @BeforeAll
    public static void setUp() {
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

        x = new Link(home, "x", applications);
        y = new Link(code, "y", b);
    }

    @Test
    public void getRootDirsOfFileSystem() {
        FileSystem.getFileSystem().addRootDir(root);

        LinkedList<Directory> expected = new LinkedList<>(Arrays.asList(root));
        LinkedList<Directory> actual = FileSystem.getFileSystem().getRootDirs();
        assertEquals(expected, actual);
    }
}