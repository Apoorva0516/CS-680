package src.edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



import edu.umb.cs680.hw10.APFS.*;
import org.junit.jupiter.api.BeforeAll;


import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VisitorTest{

    private static APFS apfs;
    private static ApfsDirectory root, applications, home, code;
    private static ApfsFile games,music, photos, mail, contacts, address;
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
        mail = new ApfsFile(home, "mail", 10);
        code = new ApfsDirectory(home, "code");
        home.appendChild(photos);
        home.appendChild(mail);
        home.appendChild(code);

        contacts = new ApfsFile(code, "contacts", 10);
        address = new ApfsFile(code, "address", 10);
        code.appendChild(contacts);
        code.appendChild(address);

        x = new ApfsLink(home, "x", applications);
        y = new ApfsLink(code, "y", music);
        home.appendChild(x);
        code.appendChild(y);
    }

    @Test
    public void testCountingOfRoot() {
        int[] expected = {4, 6, 2};

        ApfsCountingVisitor v = new ApfsCountingVisitor();
        root.accept(v);
        int[] actual = {v.getDirNum(), v.getFileNum(), v.getLinkNum()};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testCountingOfHome() {
        int[] expected = {2, 4, 2};

        ApfsCountingVisitor v = new ApfsCountingVisitor();
        home.accept(v);
        int[] actual = {v.getDirNum(), v.getFileNum(), v.getLinkNum()};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testFileCrawlingOfRoot() {
        LinkedList<ApfsFile> expected = new LinkedList<>(Arrays.asList(games,music, photos, mail, contacts, address));

        ApfsFileCrawlingVisitor v = new ApfsFileCrawlingVisitor();
        root.accept(v);
        LinkedList<ApfsFile> actual = v.getFiles();
        assertEquals(expected, actual);
    }

    @Test
    public void testFileCrawlingOfApplications() {
        LinkedList<ApfsFile> expected = new LinkedList<>(Arrays.asList(games,music));

        ApfsFileCrawlingVisitor v = new ApfsFileCrawlingVisitor();
        applications.accept(v);
        LinkedList<ApfsFile> actual = v.getFiles();
        assertEquals(expected, actual);
    }

    @Test
    public void testSearchGamesInRoot() {
        LinkedList<ApfsFile> expected = new LinkedList<>(Arrays.asList(games));

        ApfsFileSearchVisitor v = new ApfsFileSearchVisitor("games");
        root.accept(v);
        LinkedList<ApfsFile> actual = v.getFoundFiles();
        assertEquals(expected, actual);
    }

    @Test
    public void testSearchMusicInHome() {
        LinkedList<ApfsFile> expected = new LinkedList<>();

        ApfsFileSearchVisitor v = new ApfsFileSearchVisitor("music");
        home.accept(v);
        LinkedList<ApfsFile> actual = v.getFoundFiles();
        assertEquals(expected, actual);
    }
}