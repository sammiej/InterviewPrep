package CTCI;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by sammiej on 5/10/18
 */
public class ArraysAndStrings {

    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("taco catds"));
    }

    public static boolean isUnique(String myString) {
        if(myString == null || myString.length() > 128) {
            return false;
        }

        boolean[] chars = new boolean[128];
        for(int i=0; i<myString.length(); i++) {
            int val = myString.charAt(i);
            if(chars[val]) {
                return false;
            }
            chars[val] = true;
        }
        return true;
    }

    public static boolean isPermutation(String string1, String string2) {
        if(string1.length() != string2.length()) return false;

        int[] letters = new int[128];
        for(int i=0; i<string1.length(); i++) {
            int val = (int) string1.charAt(i);
            letters[val] += 1;
        }

        for(int j=0; j<string2.length(); j++) {
            int val = (int) string2.charAt(j);
            letters[val]--;
            if(letters[j] < 0) return false;
        }

        return true;
    }

    public void URLify(char[] sArray, int trulen) {
        int index;

        index = sArray.length-1;
        for(int j=trulen - 1; j>=0; j--) {
            if(sArray[j] == ' ') {
                sArray[index] = '0';
                sArray[index-1] = '2';
                sArray[index-2] = '%';
                index = index - 3;
            } else {
                sArray[index] = sArray[j];
                index--;
            }
        }
    }

    public static boolean isPalindromePermutation(String s) {
        s = s.trim().replaceAll("\\s", "").toUpperCase();

        int[] charArray = new int[128];
        for(int i=0; i<s.length(); i++) {
            int val = (int) s.charAt(i);
            charArray[val]++;
        }

        boolean oddFound = false;

        for(int j : charArray) {
            if(j % 2 == 1) {
                if(oddFound) return false;
                oddFound = true;
            }
        }

        return true;
    }


}