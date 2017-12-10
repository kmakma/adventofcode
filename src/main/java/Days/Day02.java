package Days;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * solution part one: 21845
 * <p>
 * solution part two: 191
 *
 * @see <a href="http://adventofcode.com/2017/day/2">Advent of Code: Day 2</a>
 */
public class Day02 extends Day {

    private int checksum;

    public Day02() {
        System.out.println("\n--- Day 2: Corruption Checksum ---");
        // input
        String input = readLinesToString();
        // wörk
        List<List<Integer>> spreadsheet = splitInputToMatrix(input);
        if (spreadsheet != null) {
            calculateChecksumPart1(spreadsheet);
            calculateChecksumPart2(spreadsheet);
        }
        System.out.println();
        // finished
    }

    public static void main(String[] args) {
        new Day02();
    }


    @NotNull
    @Override
    String getDefaultInput() {
        return MyInput.DAY02.getInput();
    }

    @Nullable
    private List<List<Integer>> splitInputToMatrix(String input) {
        BufferedReader bufferedReader = new BufferedReader(new StringReader(input));
        String line;
        List<List<Integer>> inputLines = new ArrayList<>();
        do {
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                System.err.println("Day02: IOException while reading string.");
                return null;
            }
            if (line == null) {
                break;
            }
            List<Integer> splitLine = splitLineToList(line);
            if (splitLine == null) {
                return null;
            }
            inputLines.add(splitLine);
        } while (!"".equals(line));
        return inputLines;
    }

    @Nullable
    private List<Integer> splitLineToList(@NotNull String line) {
        List<Integer> list = new ArrayList<>();
        String[] splitLine = line.split("\t");
        for (String element : splitLine) {
            try {
                list.add(Integer.parseInt(element));
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return list;
    }

    private void calculateChecksumPart1(List<List<Integer>> inputMatrix) {
        checksum = 0;
        for (List<Integer> line : inputMatrix) {
            int difference = Collections.max(line) - Collections.min(line);
            checksum += difference;
        }
        System.out.println("Solution Part One:");
        System.out.println("\t" + checksum);
    }

    private void calculateChecksumPart2(List<List<Integer>> inputMatrix) {
        checksum = 0;
        for (List<Integer> line : inputMatrix) {
            checksum += findCorrectQuotient(line);
        }
        System.out.println("Solution Part Two:");
        System.out.println("\t" + checksum);
    }

    @Contract(pure = true)
    private int findCorrectQuotient(List<Integer> line) {
        for (int dividend : line) {
            for (int divisor : line) {
                if (dividend != divisor && dividend % divisor == 0) {
                    return dividend / divisor;
                }
            }
        }
        return 0;
    }
}
