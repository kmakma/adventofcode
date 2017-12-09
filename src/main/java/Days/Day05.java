package Days;

import org.jetbrains.annotations.NotNull;

/**
 * solution part one: 374269
 * <p>
 * solution part two: 27720699
 *
 * @see <a href="http://adventofcode.com/2017/day/5">Advent of Code: Day 5</a>
 */
public class Day05 extends Day {

    public Day05() {
        System.out.println("\n--- Day 5: A Maze of Twisty Trampolines, All Alike ---");
        // input
        String input = readLines();
        // wörk
        int[] inputArr = inputToArray(input);
        if (inputArr != null) {
            easyJumps(inputArr);
            complexJumps(inputArr);
        }
        System.out.println();
        // finished
    }

    public static void main(String[] args) {
        new Day05();
    }

    private void complexJumps(int[] inputArr) {
        int[] input = new int[inputArr.length];
        System.arraycopy(inputArr, 0, input, 0, inputArr.length);
        int steps = 0;
        int oldIndex;
        int nextIndex = 0;
        while (isInBounds(nextIndex, input.length)) {
            oldIndex = nextIndex;
            nextIndex = oldIndex + input[nextIndex];
            if (input[oldIndex] < 3) {
                input[oldIndex]++;
            } else {
                input[oldIndex]--;
            }
            steps++;
        }
        System.out.println("Solution Part Two:");
        System.out.println("\t" + steps);
    }

    private void easyJumps(int[] inputArr) {
        int[] input = new int[inputArr.length];
        System.arraycopy(inputArr, 0, input, 0, inputArr.length);
        int steps = 0;
        int oldIndex;
        int nextIndex = 0;
        while (isInBounds(nextIndex, input.length)) {
            oldIndex = nextIndex;
            nextIndex = oldIndex + input[nextIndex];
            input[oldIndex]++;
            steps++;
        }
        System.out.println("Solution Part One:");
        System.out.println("\t" + steps);
    }

    private boolean isInBounds(int index, int size) {
        return index >= 0 && index < size;
    }

    private int[] inputToArray(String input) {
        String[] stringArr = input.split("\n");
        int[] intArr = new int[stringArr.length];
        for (int i = 0; i < stringArr.length; i++) {
            try {
                intArr[i] = Integer.parseInt(stringArr[i]);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return intArr;
    }

    @NotNull
    @Override
    String getDefaultInput() {
        return MyInput.DAY05.getInput();
    }
}