package processor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class TextProcessorTest {
    TextProcessor textProcessor = new TextProcessor();

    @Test
    public void testProcessWords() {
        // GIVEN
        String text = "Hello world & good morning. The date is 18/05/2016";
        List<String> words = Arrays.asList(text.trim().split("\\s+")); //Using List because it's ordered and easy to manipulate
        Map<Integer, Integer> expectedMap = new TreeMap<>() {{
            put(1, 1);
            put(2, 1);
            put(3, 1);
            put(4, 2);
            put(5, 2);
            put(7, 1);
            put(10, 1);
        }};

        // WHEN
        Map<Integer, Integer> wordMap = textProcessor.processWords(words);

        // THEN
        assertEquals(expectedMap, wordMap);
    }


    @Test
    public void testProcessEmptyWords() {
        // GIVEN
        String text = "";
        List<String> words = Arrays.asList(text.trim().split("\\s+")); //Using List because it's ordered and easy to manipulate
        Map<Integer, Integer> expectedMap = new TreeMap<>();

        // WHEN
        Map<Integer, Integer> wordMap = textProcessor.processWords(words);

        // THEN
        assertEquals(expectedMap, wordMap);
    }

    @Test
    public void testGetAverage() {
        // GIVEN
        Map<Integer, Integer> map = new TreeMap<>() {{
            put(1, 4);
            put(2, 5);
            put(3, 8);
            put(4, 10);
            put(5, 22);
        }};

        // WHEN
        double average = textProcessor.getAverage(map);

        // THEN
        assertEquals(9.8, average);
    }

    @Test
    public void testGetEmptyAverage() {
        // GIVEN
        Map<Integer, Integer> map = new TreeMap<>();

        // WHEN, THEN
        Assertions.assertThrows(IllegalArgumentException.class, () -> textProcessor.getAverage(map));
    }

    @Test
    public void testGetOneValueAverage() {
        // GIVEN
        Map<Integer, Integer> map = new TreeMap<>() {{
            put(1, 1);
        }};

        // WHEN
        double average = textProcessor.getAverage(map);

        // THEN
        assertEquals(1, average);
    }

    @Test
    public void testGetNullValueAverage() {
        // GIVEN
        Map<Integer, Integer> map = new TreeMap<>() {{
            put(1, null);
        }};

        // WHEN, THEN
        Assertions.assertThrows(NullPointerException.class, () -> textProcessor.getAverage(map));
    }

}