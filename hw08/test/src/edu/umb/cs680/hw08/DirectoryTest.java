package edu.umb.cs680.hw08;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class DirectoryTest {

    private String[] dirToStringArray(Directory d) {
        String[] dirInfo = {
                d.getName(),
                String.valueOf(d.isDirectory()),
                String.valueOf(d.getSize()),
                String.valueOf(d.countChildren()),
                String.valueOf(d.getTotalSize())
        };

        return dirInfo;
    }

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
        y = new Link(code, "y", music);
        home.appendChild(x);
        code.appendChild(y);
    }

    @Test
    public void verifyDirectoryEqualityRoot() {
        String[] expected = {"root", "true", "0", "2", "60"};
        String[] actual = dirToStringArray(root);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyDirectoryEqualityApplications() {
        String[] expected = {"applications", "true", "0", "2", "20"};
        String[] actual = dirToStringArray(applications);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyDirectoryEqualityHome() {
        String[] expected = {"home", "true", "0", "4", "40"};
        String[] actual = dirToStringArray(home);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyDirectoryEqualityCode() {
        String[] expected = {"code", "true", "0", "3", "20"};
        String[] actual = dirToStringArray(code);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getChildrenOfRoot() {
        LinkedList<FSElement> expected = new LinkedList<>(Arrays.asList(applications, home));
        LinkedList<FSElement> actual = root.getChildren();
        assertEquals(expected, actual);
    }


    @Test
    public void getFilesOfRoot() {
        LinkedList<File> expected = new LinkedList<>();
        LinkedList<File> actual = root.getFiles();
        assertEquals(expected, actual);
    }

    @Test
    public void getFilesOfCode() {
        LinkedList<File> expected = new LinkedList<>(Arrays.asList(a, b));
        LinkedList<File> actual = code.getFiles();
        assertEquals(expected, actual);
    }


    @Test
    public void getSubDirectoriesOfHome() {
        LinkedList<Directory> expected = new LinkedList<>(Arrays.asList(code));
        LinkedList<Directory> actual = home.getSubDirectories();
        assertEquals(expected, actual);
    }

    @Test
    public void getParentOfHome() {
        String expected = home.getParent().getName();
        String actual = "root";
        assertEquals(expected, actual);
    }

    @Test
    public void getChildrenOfHome() {
        LinkedList<FSElement> expected = new LinkedList<>(Arrays.asList(photos, books, code, x));
        LinkedList<FSElement> actual = home.getChildren();
        assertEquals(expected, actual);
    }

    @Test
    public void getChildrenOfCode() {
        LinkedList<FSElement> expected = new LinkedList<>(Arrays.asList(a, b, y));
        LinkedList<FSElement> actual = code.getChildren();
        assertEquals(expected, actual);
    }
}