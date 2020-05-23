package edu.umb.cs680.hw08;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkTest {
    private String[] linkToStringArray(Link l) {
        String[] linkInfo = {
                l.getName(),
                String.valueOf(l.isDirectory()),
                String.valueOf(l.getSize()),
                l.getParent().getName(),
                l.getTarget().getName()
        };

        return linkInfo;
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
    public void verifyLinkEqualityX() {
        String[] expected = {"x", "false", "0", "home", "applications"};
        String[] actual = linkToStringArray(x);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyLinkEqualityY() {
        String[] expected = {"y", "false", "0", "code", "music"};
        String[] actual = linkToStringArray(y);
        assertArrayEquals(expected, actual);
    }
}