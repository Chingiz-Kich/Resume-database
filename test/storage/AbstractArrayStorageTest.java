package storage;

import exception.StorageException;
import model.Resume;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static storage.AbstractArrayStorage.STORAGE_LIMIT;

public class AbstractArrayStorageTest extends  AbstractStorageTest {
    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test
    public void saveStorageOverflow() {
        assertThrows(StorageException.class, () -> {
            for (int i = 0; i < STORAGE_LIMIT; i++) {
                Resume resume = new Resume("newName"+i);
                storage.save(resume);
            }
        });
    }
}
