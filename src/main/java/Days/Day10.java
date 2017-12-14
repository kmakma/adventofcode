package Days;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * solution part one: 212
 * <p>
 * solution part two: 96DE9657665675B51CD03F0B3528BA26
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
        if (inputOne != null) {
            doEasyHash(inputOne);
        }
        if (inputTwo != null) {
            inputTwo = addSuffix(inputTwo);
            int[] denseHash = getDenseHash(inputTwo);
            printDenseHashToHex(denseHash);
        }
        System.out.println();
        // finished
    }

    public static void main(String[] args) {
        new Day10();
    }

    private void printDenseHashToHex(int[] denseHash) {
        StringBuilder sb = new StringBuilder();
        for (int hash : denseHash) {
            sb.append(String.format("%02X", hash));
        }

        System.out.println("Solution Part Two:");
        System.out.println("\t" + sb.toString());
    }

    private int[] getDenseHash(int[] input) {
        doSparseHash(input);
        int[] denseHash = new int[theList.length / 16];
        for (int i = 0; i < theList.length / 16; i++) {
            denseHash[i] = useBitwiseXOR(Arrays.copyOfRange(theList, 16 * i, 16 * i + 16));
        }
        return denseHash;
    }

    private int useBitwiseXOR(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result ^= array[i];
        }
        return result;
    }

    private void doSparseHash(int[] input) {
        int currentPosition = 0;
        int jumpSize = 0;
        theList = new int[256];
        for (int i = 0; i < theList.length; i++) {
            theList[i] = i;
        }
        for (int i = 0; i < 64; i++) {
            for (int length : input) {
                reverseSubarray(currentPosition, length);
                currentPosition = normalizeIndex(currentPosition + length + jumpSize, theList.length);
                jumpSize++;
            }
        }
    }

    private int[] addSuffix(int[] input) {
        int[] suffix = {17, 31, 73, 47, 23};
        int[] newArray = new int[input.length + suffix.length];
        System.arraycopy(input, 0, newArray, 0, input.length);
        System.arraycopy(suffix, 0, newArray, input.length, suffix.length);
        return newArray;
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