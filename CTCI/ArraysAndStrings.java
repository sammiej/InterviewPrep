package CTCI;

/**
 * Created by sammiej on 5/10/18
 */
public class ArraysAndStrings {

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

    public static String URLify(String string, int trulen) {
        int index;

        char[] sArray = string.toCharArray();
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
        return new String(sArray);
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

    public static boolean isOneAway(String string1, String string2) {
        boolean oneAway = false;

        if(Math.abs(string1.length() - string2.length()) > 1) return false;

        String longer = string1.length() >= string2.length() ? string1 : string2;
        String shorter = string1.length() < string2.length() ? string1 : string2;

        int longIndex = 0;
        int shortIndex = 0;

        while(longIndex < longer.length() && shortIndex < shorter.length()) {
            if (longer.charAt(longIndex) != shorter.charAt(shortIndex)) {
                if (oneAway) return false;

                if (longer.length() == shorter.length()) shortIndex++;
                oneAway = true;
            } else {
                shortIndex++;
            }
            longIndex++;
        }

        return oneAway;
    }

    public static String stringCompression(String myString) {
        StringBuilder sb = new StringBuilder();

        int charCount = 1;

        sb.append(myString.charAt(0));

        for(int i = 1; i < myString.length(); i++) {
            if(myString.charAt(i) == myString.charAt(i-1)) {
                charCount++;
            } else {
                sb.append(charCount);
                sb.append(myString.charAt(i));
                charCount = 1;
            }
        }
        sb.append(charCount);

        if(sb.length() == myString.length() * 2) return myString;

        return sb.toString();
    }

    public static boolean stringRotation(String string1, String string2) {
        if(string1.length() != string2.length() || string1.length() == 0) return false;

        String concat = string2.concat(string2);
        return concat.contains(string1);
    }
}
