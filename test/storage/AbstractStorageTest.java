package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractStorageTest {
    protected final Storage storage;

    private static final Resume RESUME1 = new Resume("uuid1", "name1");

    private static final Resume RESUME2 = new Resume("uuid2", "name2");

    private static final Resume RESUME3 = new Resume("uuid3", "name3");

    private static final Resume RESUME4 = new Resume("uuid4", "name4");

    public AbstractStorageTest(Storage storage) {
       this.storage = storage;
    }
    
    @BeforeEach
    public void setUp() {
        storage.clear();
        storage.save(RESUME1);
        storage.save(RESUME2);
        storage.save(RESUME3);
    }

    @Test
    public void size() {
        assertEquals(3, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        Resume newResume = new Resume("uuid1", "newName");
        storage.update(newResume);
        assertSame(newResume, storage.get("uuid1"));
    }

    @Test void updateNotExist() {
        assertThrows(NotExistStorageException.class, () -> storage.update(RESUME4));
    }

    @Test
    public void getAllSorted() {
        List<Resume> resumes = storage.getAllSorted();
        assertArrayEquals(resumes.toArray(), storage.getAllSorted().toArray());
    }

    @Test
    public void save() {
        storage.save(RESUME4);
        assertEquals(4, storage.size());
    }

    @Test
    public void saveExistStorage() {
        assertThrows(ExistStorageException.class, () -> storage.save(RESUME1));
    }

    @Test
    public void delete() {
        storage.delete(RESUME1.getUuid());
        assertEquals(2, storage.size());
    }

    @Test
    public void deleteNotExist() {
        assertThrows(NotExistStorageException.class, () -> storage.delete("dummy"));
    }

    @Test
    public void get() {
        assertEquals("uuid1", RESUME1.getUuid());
        assertEquals("uuid2", RESUME2.getUuid());
        assertEquals("uuid3", RESUME3.getUuid());
        assertGet(RESUME1);
        assertGet(RESUME2);
        assertGet(RESUME3);
    }

    @Test
    public void getNotExist() {
        assertThrows(NotExistStorageException.class, () -> storage.get("dummy"));
    }

    private void assertGet(Resume r) {
        assertEquals(r, storage.get(r.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }
}