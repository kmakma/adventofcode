package Days;

import org.jetbrains.annotations.NotNull;

/**
 * solution part one: 1144
 * <p>
 * solution part two: 1194
 *
 * @see <a href="http://adventofcode.com/2017/day/1">Advent of Code: Day 1</a>
 */
public class Day01 extends Day {

    public Day01() {
        System.out.println("\n--- Day 1: Inverse Captcha ---");
        // input
        int[] input = (int[]) parseInputLine(Return.INT_ARRAY);
        // wörk
        if (input != null) {
            compareSuccessivePairs(input);
            compareHalfwayAroundPairs(input);
        }
        System.out.println();
        // finished
    }

    public static void main(String[] args) {
        new Day01();
    }

    private void compareSuccessivePairs(@NotNull int[] input) {
        int sum = 0;
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] == (input[i + 1])) {
                sum += input[i];
            }
        }
        if (input[input.length - 1] == (input[0])) {
            sum += input[0];
        }
        System.out.println("Solution Part One:");
        System.out.println("\t" + sum);
    }

    private void compareHalfwayAroundPairs(@NotNull int[] input) {
        int sum = 0;
        int half = input.length / 2;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == (input[normalizeIndex(i + half, input.length)])) {
                sum += input[i];
            }
        }
        System.out.println("Solution Part Two:");
        System.out.println("\t" + sum);
    }

    @NotNull
    @Override
    String getDefaultInput() {
        return MyInput.DAY01.getInput();
    }
}
