package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class TextUtilTest {
    @Test
    public void testReadTextFile() {
        // GIVEN
        String file = "test.txt";

        // WHEN
        String text = TextUtil.readText(file);

        // THEN
        assertEquals("Hello world & good morning. The date is 18/05/2016", text);
    }
    @Test
    public void testNotExistingFile() {
        // GIVEN
        String file = "no_file";

        // WHEN, THEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> TextUtil.readText(file));
    }

}