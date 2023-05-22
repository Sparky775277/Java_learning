import java.math.BigInteger;
import java.util.*;
import java.util.function.ToIntFunction;

public class SubstringSearch {

    private SubstringSearch() {
    }

    public static List<Integer> boyerMoore(String string, String substring) {
        if (string == null || substring == null)
            throw new IllegalArgumentException("Strings can't be null's");

        int substringLength = substring.length();
        int stringLength = string.length();

        if (substringLength > stringLength || stringLength == 0)
            return new ArrayList<Integer>();

        if (substringLength == 0)
            throw new IllegalArgumentException("Substring for search can't be empty");

        Map<Character, Integer> offsets = new HashMap<>();

        for (int i = 1; i <= substringLength - 1; i++) {
            char ch = substring.charAt(substringLength - i - 1);
            if (!offsets.containsKey(ch))
                offsets.put(ch, i);
        }

        char ch = substring.charAt(substringLength - 1);
        if (!offsets.containsKey(ch))
            offsets.put(ch, substringLength);

        List<Integer> result = new ArrayList<>();

        int i = substringLength - 1;
        while (i < stringLength) {
            if (string.charAt(i) == substring.charAt(substringLength - 1)) {
                if (boyerMoorePrivate(string, i, substring)) {
                    result.add(i - substringLength + 1);
                    i++;
                } else
                    i += offsets.get(substring.charAt(substringLength - 1));
            } else
                i += offsets.getOrDefault(string.charAt(i), substringLength);
        }

        return result;
    }

    private static boolean boyerMoorePrivate(String string, int index, String substring) {
        for (int i = substring.length() - 1; i >= 0; i--) {
            if (string.charAt(index) == substring.charAt(i))
                index--;
            else
                return false;
        }
        return true;
    }


    public static List<Integer> knuthMorrisPratt(String string, String pattern) {
        Objects.requireNonNull(string);
        Objects.requireNonNull(pattern);
        int patternLength = pattern.length();
        int stringLength = string.length();

        if (patternLength > stringLength || stringLength == 0) {
            return new ArrayList<Integer>();
        }
        if (patternLength == 0) {
            throw new IllegalArgumentException("Pattern length should be > 0");
        }
        List<Integer> result = new ArrayList<>();
        int[] prefTable = getPrefixTableKnuthMorrisPratt(pattern);
        int pointer = 0;
        for (int i = 0; i < stringLength; i++) {
            while (true) {
                if (pattern.charAt(pointer) == string.charAt(i)) {
                    pointer++;
                    if (pointer == patternLength) {
                        i = i + 1 - patternLength;
                        result.add(i);
                        pointer = 0;
                    }
                    break;
                }
                if (pointer == 0) {
                    break;
                }
                pointer = prefTable[pointer - 1];
            }
        }

        return result;
    }

    private static int[] getPrefixTableKnuthMorrisPratt(String str) {
        int[] table = new int[str.length()];
        int k = 0;
        for (int i = 1; i < str.length(); i++) {
            while (k > 0 && str.charAt(i) != str.charAt(k)) {
                k = table[k - 1];
            }
            if (str.charAt(i) == str.charAt(k)) {
                k++;
            }
            table[i] = k;
        }

        return table;
    }

    public static List<Integer> finiteAutomata(String string, String pattern) {
        Objects.requireNonNull(string);
        Objects.requireNonNull(pattern);
        int patternLength = pattern.length();
        int stringLength = string.length();

        if (patternLength > stringLength || stringLength == 0) {
            return new ArrayList<Integer>();
        }
        if (patternLength == 0) {
            throw new IllegalArgumentException("Pattern length should be > 0");
        }

        // get state table
        char[] chars = pattern.toCharArray();
        Set<Character> charsSet = new HashSet<>();
        for (char c : chars) {
            charsSet.add(c);
        }
        List<Character> uniqueCharsList = new ArrayList<>(charsSet);
        int uniqueChars = charsSet.size();

        int[][] stateTable = new int[patternLength + 1][uniqueChars];

        for (int state = 0; state < patternLength; state++) {
            for (int i = 0; i < uniqueChars; i++) {
                stateTable[state][i] = getNextState(pattern, state, uniqueCharsList.get(i));
            }
        }

        List<Integer> result = new ArrayList<>();
        int state = 0;
        for (int i = 0; i < stringLength; i++) {
            if (!charsSet.contains(string.charAt(i))) {
                state = 0;
                continue;
            }

            state = stateTable[state][uniqueCharsList.indexOf(string.charAt(i))];
            if (state == patternLength) {
                i = i - patternLength + 1;
                result.add(i);
                state = 0;
            }
        }

        return result;
    }

    private static int getNextState(String str, int state, char ch) {

        if (state < str.length() && ch == str.charAt(state)) {
            return state + 1;
        }

        for (int newState = state; newState > 0; newState--) {
            if (str.charAt(newState - 1) == ch) {
                int i;
                for (i = 0; i < newState - 1; i++) {
                    if (str.charAt(i) != str.charAt(state - newState + 1 + i)) {
                        break;
                    }
                }
                if (i == newState - 1) {
                    return newState;
                }
            }
        }

        return 0;
    }

}
