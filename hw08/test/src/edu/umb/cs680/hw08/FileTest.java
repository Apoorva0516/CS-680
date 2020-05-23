package edu.umb.cs680.hw08;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileTest {

    private String[] fileToStringArray(File f) {
        String[] fileInfo = {
                f.getName(),
                String.valueOf(f.isDirectory()),
                String.valueOf(f.getSize()),
                f.getParent().getName()
        };

        return fileInfo;
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
    public void verifyFileEquality1() {
        String[] expected = {"games", "false", "10", "applications"};
        String[] actual = fileToStringArray(games);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileEquality2() {
        String[] expected = {"music", "false", "10", "applications"};
        String[] actual = fileToStringArray(music);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileEquality3() {
        String[] expected = {"photos", "false", "10", "home"};
        String[] actual = fileToStringArray(photos);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileEquality4() {
        String[] expected = {"books", "false", "10", "home"};
        String[] actual = fileToStringArray(books);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileEquality5() {
        String[] expected = {"a", "false", "10", "code"};
        String[] actual = fileToStringArray(a);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyFileEquality6() {
        String[] expected = {"b", "false", "10", "code"};
        String[] actual = fileToStringArray(b);
        assertArrayEquals(expected, actual);
    }
}