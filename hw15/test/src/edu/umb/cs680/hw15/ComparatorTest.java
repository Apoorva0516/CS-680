package edu.umb.cs680.hw15;

import edu.umb.cs680.hw15.APFS.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ComparatorTest {

    private String[] APFSElementToString(LinkedList<ApfsElement> elements) {
        String[] elems = new String[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            elems[i] = elements.get(i).getName();
        }
        return elems;
    }

    private String[] APFSDirectoryToString(LinkedList<ApfsDirectory> elements) {
        String[] elems = new String[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            elems[i] = elements.get(i).getName();
        }
        return elems;
    }

    private String[] APFSFileToString(LinkedList<ApfsFile> elements) {
        String[] elems = new String[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            elems[i] = elements.get(i).getName();
        }
        return elems;
    }

    private static APFS apfs;
    private static ApfsDirectory root, applications, home, code;
    private static ApfsFile games,music,photos,books,a,b;

    private static ApfsLink x, y;

    @BeforeAll
    public static void setUp() {
        apfs = new APFS("Rajath");
        apfs.initFileSystem("Local Disk", 1000);
        root = apfs.getRootDir();

        applications = new ApfsDirectory(root, "applications");
        home = new ApfsDirectory(root, "home");
        root.appendChild(applications);
        root.appendChild((home));

        games = new ApfsFile(applications, "games", 10);
        music = new ApfsFile(applications, "music", 10);
        applications.appendChild(games);
        applications.appendChild(music);

        photos = new ApfsFile(home, "photos", 10);
        books = new ApfsFile(home, "books", 10);
        code = new ApfsDirectory(home, "code");
        home.appendChild(photos);
        home.appendChild(books);
        home.appendChild(code);

        a = new ApfsFile(code, "a", 10);
        b = new ApfsFile(code, "b", 10);
        code.appendChild(a);
        code.appendChild(b);

        x = new ApfsLink(home, "x", applications);
        y = new ApfsLink(code, "y", music);
        home.appendChild(x);
        code.appendChild(y);

        // Set Modified Time For Test Purpose
        root.setLastModified(LocalDateTime.of(2020, 5, 1, 12, 0));
        home.setLastModified(LocalDateTime.of(2020, 5, 3, 12, 0));
        applications.setLastModified(LocalDateTime.of(2020, 2, 5, 12, 0));
        code.setLastModified(LocalDateTime.of(2020, 5, 2, 12, 0));

        games.setLastModified(LocalDateTime.of(2020, 5, 5, 12, 0));
        music.setLastModified(LocalDateTime.of(2020, 5, 5, 12, 0));
        photos.setLastModified(LocalDateTime.of(2020, 5, 6, 12, 0));
        books.setLastModified(LocalDateTime.of(2020, 5, 3, 12, 0));
        a.setLastModified(LocalDateTime.of(2020, 5, 5, 12, 0));
        b.setLastModified(LocalDateTime.of(2020, 5, 5, 12, 0));

        x.setLastModified(LocalDateTime.of(2020, 5, 4, 12, 0));
        y.setLastModified(LocalDateTime.of(2020, 5, 5, 12, 0));
    }

    @Test
    public void testGetChilrenOfRoot() {
        String[] expected = {"applications", "home"};
        LinkedList<ApfsElement> children = root.getChildren();
        String[] actual = APFSElementToString(children);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetSubDirOfRoot() {
        String[] expected = {"applications", "home"};
        LinkedList<ApfsDirectory> subDirectories = root.getSubDirectories();
        String[] actual = APFSDirectoryToString(subDirectories);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetSubDirOfRootReversedAlphabetical() {
        String[] expected = {"home", "applications"};
        LinkedList<ApfsDirectory> subDirectories = root.getSubDirectories(Comparator.comparing((ApfsElement element) -> element.getName(), Comparator.reverseOrder()));
        String[] actual = APFSDirectoryToString(subDirectories);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetChilrenOfHome() {
        String[] expected = {"books", "code", "photos", "x"};
        LinkedList<ApfsElement> children = home.getChildren();
        String[] actual = APFSElementToString(children);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void sortChildrenOfHomeReverseAlphabetical() {
        String[] expected = {"x", "photos", "code", "books"};
        LinkedList<ApfsElement> children = home.getChildren(Comparator.comparing((ApfsElement element) -> element.getName(), Comparator.reverseOrder()));
        String[] actual = APFSElementToString(children);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void sortFileOfHomeReverseAlphabetical() {
        String[] expected = {"photos", "books"};
        LinkedList<ApfsFile> files = home.getFiles(Comparator.comparing(ApfsElement::getName, Comparator.reverseOrder()));
        String[] actual = APFSFileToString((files));
        assertArrayEquals(expected, actual);
    }

    @Test
    void sortChildrenOfTimeStampBased() {
        String[] expected = {"photos", "x", "books", "code"};
        LinkedList<ApfsElement> children = home.getChildren(Comparator.comparing(ApfsElement::getLastModified, Comparator.reverseOrder()));
        String[] actual = APFSElementToString(children);
        assertArrayEquals(expected, actual);
    }
}