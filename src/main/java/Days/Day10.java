package Days;

import org.jetbrains.annotations.NotNull;

/**
 * solution part one: ___
 * <p>
 * solution part two: ___
 *
 * @see <a href="http://adventofcode.com/2017/day/10">Advent of Code: Day 10</a>
 */
public class Day10 extends Day {

    private int[] theList;

    public Day10() {
        System.out.println("\n--- Day 10: Knot Hash ---");
        // input
        String inputLine = readLine();
        int[] inputOne = lineToIntArray(inputLine, REGEX_COMMA);
        int[] inputTwo = lineToAsciiIntArray(inputLine);
        // wörk
        // TODO: 09.12.2017 work with input
        if (inputOne != null) {
            doEasyHash(inputOne);
        }
        if(inputTwo!=null) {
//            int[] sparseHash = doSparseHash(inputTwo);

        }

        System.out.println();
        // finished
    }

    public static void main(String[] args) {
        new Day10();
    }

    private void doEasyHash(int[] input) {
        int currentPosition = 0;
        int jumpSize = 0;
        theList = new int[256];
        for (int i = 0; i < theList.length; i++) {
            theList[i] = i;
        }
        for (int length : input) {
            reverseSubarray(currentPosition, length);
            currentPosition += length + jumpSize;
            jumpSize++;
        }
        int checkInt = theList[0] * theList[1];
        System.out.println("Solution Part One:");
        System.out.println("\t" + checkInt);
    }

    private void reverseSubarray(int startIndex, int length) {
        for (int i = 0; i < length / 2; i++) {
            int fstI = normalizeIndex(i + startIndex, theList.length);
            int sndI = normalizeIndex(startIndex + length - 1 - i, theList.length);

            int temp = theList[fstI];
            theList[fstI] = theList[sndI];
            theList[sndI] = temp;
        }
    }

    @NotNull
    @Override
    String getDefaultInput() {
        return MyInput.DAY10.getInput();
    }
}