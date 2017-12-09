package Days;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * solution part one: 451
 * <p>
 * solution part two: 223
 *
 * @see <a href="http://adventofcode.com/2017/day/4">Advent of Code: Day 4</a>
 */
public class Day04 extends Day {

    public Day04() {
        System.out.println("\n--- Day 4: High-Entropy Passphrases ---");
        // input
        String input = readLines();
        // wörk
        // TODO: 06.12.2017 work with input
        List<String[]> inputList = createList(input);
        if (inputList != null && !inputList.isEmpty()) {
            checkLinesEasy(inputList);
            checkLinesExpert(inputList);
        }
        System.out.println();
        // finished
    }

    public static void main(String[] args) {
        new Day04();
    }

    private void checkLinesExpert(List<String[]> inputList) {
        int validLines = 0;
        for (String[] line : inputList) {
            if (checkIfValidExpert(line)) {
                validLines++;
            }
        }
        System.out.println("Solution Part Two:");
        System.out.println("\t" + validLines);
    }

    private boolean checkIfValidExpert(String[] line) {
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                if (line[i].equals(line[j]) || areAnagrams(line[i], line[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean areAnagrams(String firstS, String scndS) {
        if (firstS.length() != scndS.length()) {
            return false;
        }
        char[] first = firstS.toCharArray();
        char[] scnd = scndS.toCharArray();
        Map<Character, Integer> charsInFirst = new HashMap<>();

        for (char c : first) {
            int count;
            if (charsInFirst.containsKey(c)) {
                count = charsInFirst.get(c) + 1;
            } else {
                count = 1;
            }
            charsInFirst.put(c, count);
        }

        for (char c : scnd) {
            if (!charsInFirst.containsKey(c)) {
                return false;
            }
            charsInFirst.put(c, charsInFirst.get(c) - 1);
        }

        for (Integer i : charsInFirst.values()) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    private void checkLinesEasy(List<String[]> inputList) {
        int validLines = 0;
        for (String[] line : inputList) {
            if (checkIfValidEasy(line)) {
                validLines++;
            }
        }
        System.out.println("Solution Part One:");
        System.out.println("\t" + validLines);
    }

    private boolean checkIfValidEasy(String[] line) {
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                if (line[i].equals(line[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<String[]> createList(String input) {
        BufferedReader br = new BufferedReader(new StringReader(input));
        String line = null;
        List<String[]> inputList = new ArrayList<>();
        while (!"".equals(line)) {
            try {
                line = br.readLine();
            } catch (IOException e) {
                System.err.println("Day04: IOException while reading string.");
                return null;
            }
            if (line == null) {
                break;
            }
            inputList.add(line.split(" "));
        }
        return inputList;
    }

    @NotNull
    @Override
    String getDefaultInput() {
        return MyInput.DAY04.getInput();
    }
}