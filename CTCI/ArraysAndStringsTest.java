package CTCI;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ArraysAndStringsTest {

    @Test
    public void isUnique() {
        assertTrue(ArraysAndStrings.isUnique("abcde"));
        assertFalse(ArraysAndStrings.isUnique("abbcde"));
    }

    @Test
    public void isPermutation() {
        assertTrue(ArraysAndStrings.isPermutation("abcde", "acbde"));
        assertFalse(ArraysAndStrings.isPermutation("abcde", "abbde"));
    }

    @Test
    public void URLify() {
        assertEquals("Mr%20John%20Smith", ArraysAndStrings.URLify("Mr John Smith    ", 13));
    }

    @Test
    public void isPalindromePermutation() {
        assertTrue(ArraysAndStrings.isPalindromePermutation("ab bca"));
    }

    @Test
    public void isOneAway() {
        assertTrue(ArraysAndStrings.isOneAway("pale", "ple"));
        assertFalse(ArraysAndStrings.isOneAway("pale", "bake"));
    }
}