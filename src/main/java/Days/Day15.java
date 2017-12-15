package Days;

import org.jetbrains.annotations.NotNull;

/**
 * solution part one: 569
 * <p>
 * solution part two: 298
 *
 * @see <a href="http://adventofcode.com/2017/day/15">Advent of Code: Day 15</a>
 */
public class Day15 extends Day {

    private final long generatorAFactor = 16807;
    private final long generatorBFactor = 48271;
    private long generatorA;
    private long generatorB;


    public Day15() {
        System.out.println("\n--- Day 15: Dueling Generators ---");
        // input
        int[] input = specialLinesToIntArr();
        // wörk
        if (input != null) {
            compareGenerators(input);
            comparePickyGenerators(input);
        }
        System.out.println();
        // finished
    }

    public static void main(String[] args) {
        new Day15();
    }

    private void comparePickyGenerators(int[] input) {
        generatorA = input[0];
        generatorB = input[1];
        int matchCounter = 0;
        for (int i = 0; i < 5000000; i++) {
            generateNewPickyValues();
            if (compareGeneratorValues()) {
                matchCounter++;
            }
        }
        System.out.println("Solution Part Two:");
        System.out.println("\t" + matchCounter);
    }

    private void generateNewPickyValues() {
        do {
            generatorA = generateNewValue(generatorA, generatorAFactor);
        } while (generatorA % 4 != 0);
        do {
            generatorB = generateNewValue(generatorB, generatorBFactor);
        } while (generatorB % 8 != 0);
    }

    private long generateNewValue(long generator, long generatorFactor) {
        long temp = generator * generatorFactor;
        return temp % 2147483647;
    }

    private void compareGenerators(int[] input) {
        generatorA = input[0];
        generatorB = input[1];
        int matchCounter = 0;
        for (int i = 0; i < 40000000; i++) {
            generateNewValues();
            if (compareGeneratorValues()) {
                matchCounter++;
            }
        }
        System.out.println("Solution Part One:");
        System.out.println("\t" + matchCounter);
    }

    private boolean compareGeneratorValues() {
        String gA = Long.toBinaryString(generatorA);
        String gB = Long.toBinaryString(generatorB);
        int beginIndexA = gA.length() - 16;
        int beginIndexB = gB.length() - 16;
        if (beginIndexA < 0 || beginIndexB < 0) {
            return false;
        }
        gA = gA.substring(beginIndexA);
        gB = gB.substring(beginIndexB);
        return gA.equals(gB);
    }


    private void generateNewValues() {
        generatorA = generateNewValue(generatorA, generatorAFactor);
        generatorB = generateNewValue(generatorB, generatorBFactor);
    }

    @NotNull
    @Override
    String getDefaultInput() {
        return MyInput.DAY15.getInput();
    }
}