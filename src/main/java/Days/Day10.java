package Days;

import org.jetbrains.annotations.NotNull;

/**
 * solution part one: 212
 * <p>
 * solution part two: 96DE9657665675B51CD03F0B3528BA26
 *
 * @see <a href="http://adventofcode.com/2017/day/10">Advent of Code: Day 10</a>
 */
public class Day10 extends Day {

    public Day10() {
        System.out.println("\n--- Day 10: Knot Hash ---");
        // input
        String inputLine = readLine();
        int[] inputOne = lineToIntArray(inputLine, REGEX_COMMA);
        int[] inputTwo = lineToAsciiIntArray(inputLine);
        // wörk
        if (inputOne != null) {
            doEasyHash(inputOne);
        }
        if (inputTwo != null) {
            getHexString(inputTwo);
        }
        System.out.println();
        // finished
    }

    public static void main(String[] args) {
        new Day10();
    }

    private void getHexString(int[] asciiIntArray) {
        String hexString = knotHashAsciiIntArrayToHex(asciiIntArray);

        System.out.println("Solution Part Two:");
        System.out.println("\t" + hexString);
    }

    private void doEasyHash(int[] input) {
        int currentPosition = 0;
        int jumpSize = 0;
        int[] theList = new int[256];
        for (int i = 0; i < theList.length; i++) {
            theList[i] = i;
        }
        for (int length : input) {
            reverseSubarrayOf(theList, currentPosition, length);
            currentPosition += length + jumpSize;
            jumpSize++;
        }
        int checkInt = theList[0] * theList[1];
        System.out.println("Solution Part One:");
        System.out.println("\t" + checkInt);
    }

    @NotNull
    @Override
    String getDefaultInput() {
        return MyInput.DAY10.getInput();
    }
}