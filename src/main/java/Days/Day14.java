package Days;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * solution part one: 8316
 * <p>
 * solution part two: 1074
 *
 * @see <a href="http://adventofcode.com/2017/day/14">Advent of Code: Day 14</a>
 */
public class Day14 extends Day {

    public Day14() {
        System.out.println("\n--- Day 14: Disk Defragmentation ---");
        // input
        String input = readLine();
        List<String> hashInput = generateHashInput(input);
        // wörk
        countStuff(hashInput);
        System.out.println();
        // finished
    }

    public static void main(String[] args) {
        new Day14();
    }

    private void countStuff(List<String> hashInput) {
        List<String> binaryValues = getBinaryValues(hashInput);
        List<boolean[]> booleanValues = parseBinaryStringsToBooleanArrays(binaryValues);
        countUsedSquares(booleanValues);
        countRegions(booleanValues);
    }

    private void countUsedSquares(@NotNull List<boolean[]> booleanValues) {
        int usedSquares = 0;
        for (boolean[] array : booleanValues) {
            for (boolean square : array) {
                if (square) {
                    usedSquares++;
                }
            }
        }
        System.out.println("Solution Part One:");
        System.out.println("\t" + usedSquares);
    }

    private void countRegions(@NotNull List<boolean[]> booleanValues) {
        int[][] regionMatrix = new int[128][128];
        fillMatrixWithDefaultRegions(regionMatrix, booleanValues);
        int regions = applyRegionsToMatrix(regionMatrix);

        System.out.println("Solution Part Two:");
        System.out.println("\t" + regions);
//        printMatrix(regionMatrix);
    }

    private void fillMatrixWithDefaultRegions(int[][] matrix, @NotNull List<boolean[]> booleanValues) {
        for (int i = 0; i < booleanValues.size(); i++) {
            for (int j = 0; j < booleanValues.get(i).length; j++) {
                if (booleanValues.get(i)[j]) {
                    matrix[i][j] = -1;
                }
            }
        }
    }

    private int applyRegionsToMatrix(@NotNull int[][] regionMatrix) {
        int counter = 0;
        for (int i = 0; i < regionMatrix.length; i++) {
            for (int j = 0; j < regionMatrix[i].length; j++) {
                if (regionMatrix[i][j] == -1) {
                    counter++;
                    spreadRegion(regionMatrix, i, j, counter);
                }
            }
        }
        return counter;
    }

    private void spreadRegion(@NotNull int[][] regionMatrix, int row, int col, int counter) {
        regionMatrix[row][col] = counter;
        if (col > 0 && regionMatrix[row][col - 1] == -1) {
            spreadRegion(regionMatrix, row, col - 1, counter);
        }
        if (row > 0 && regionMatrix[row - 1][col] == -1) {
            spreadRegion(regionMatrix, row - 1, col, counter);
        }
        if (col < regionMatrix[row].length - 1 && regionMatrix[row][col + 1] == -1) {
            spreadRegion(regionMatrix, row, col + 1, counter);
        }
        if (row < regionMatrix.length - 1 && regionMatrix[row + 1][col] == -1) {
            spreadRegion(regionMatrix, row + 1, col, counter);
        }
    }

    private List<boolean[]> parseBinaryStringsToBooleanArrays(@NotNull List<String> binaryValues) {
        List<boolean[]> booleanArrays = new ArrayList<>();
        for (String binaryValue : binaryValues) {
            boolean[] booleanArr = new boolean[binaryValue.length()];
            for (int i = 0; i < binaryValue.length(); i++) {
                booleanArr[i] = binaryValue.charAt(i) == '1';
            }
            booleanArrays.add(booleanArr);
        }
        return booleanArrays;
    }

    private List<String> getBinaryValues(List<String> hashInput) {
        List<String> hexValues = getHexadecimalValues(hashInput);
        List<String> binValues = new ArrayList<>();
        for (String hex : hexValues) {
            binValues.add(parseHexStringToBinString(hex));
        }
        return binValues;
    }

    private List<String> getHexadecimalValues(@NotNull List<String> hashInput) {
        List<String> hexValues = new ArrayList<>();
        for (String hashInputLine : hashInput) {
            hexValues.add(calculateHexValue(hashInputLine));
        }
        return hexValues;
    }

    private String calculateHexValue(String hashInput) {
        int[] asciiInput = lineToAsciiIntArray(hashInput);
        return knotHashAsciiIntArrayToHex(asciiInput);
    }

    private List<String> generateHashInput(String input) {
        List<String> hashInput = new ArrayList<>();
        for (int i = 0; i < 128; i++) {
            hashInput.add(String.format("%s-%d", input, i));
        }
        return hashInput;
    }

    @NotNull
    @Override
    String getDefaultInput() {
        return MyInput.DAY14.getInput();
    }
}