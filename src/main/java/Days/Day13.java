package Days;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * solution part one: 1928
 * <p>
 * solution part two: 3830344
 *
 * @see <a href="http://adventofcode.com/2017/day/13">Advent of Code: Day 13</a>
 */
public class Day13 extends Day {

    private Map<Integer, Integer> scannerRanges;

    public Day13() {
        System.out.println("\n--- Day 13: Packet Scanners ---");
        // input
        scannerRanges = linesToIntMap();
        // wörk
        if (scannerRanges != null) {
            checkInstantTripSeverity();
            calculateDelayTime();
        }
        System.out.println();
        // finished
    }

    public static void main(String[] args) {
        new Day13();
    }

    private void checkInstantTripSeverity() {
        int severity = checkTripSeverity(0);
        if (severity < 0) {
            severity = 0;
        }
        System.out.println("Solution Part One:");
        System.out.println("\t" + severity);
    }

    private void calculateDelayTime() {
        int delay = -1;
        int severity = 0;
        while (severity != -1) {
            delay++;
            severity = checkTripSeverity(delay);
        }
        System.out.println("Solution Part Two:");
        System.out.println("\t" + delay);
    }

    private int checkTripSeverity(int delay) {
        Map<Integer, Boolean> scannerRootPositions = new HashMap<>();
        for (Map.Entry<Integer, Integer> scanner : scannerRanges.entrySet()) {
            int range = scanner.getValue();
            int position = (scanner.getKey() + delay) % ((range - 1) * 2);
            scannerRootPositions.put(scanner.getKey(), position == 0);
        }
        return calculateSeverity(scannerRootPositions);
    }

    private int calculateSeverity(Map<Integer, Boolean> scannerRootPositions) {
        int severity = 0;
        for (Map.Entry<Integer, Boolean> scanner : scannerRootPositions.entrySet()) {
            if (scanner.getValue()) {
                severity += scanner.getKey() * scannerRanges.get(scanner.getKey());
            }
        }
        if (severity == 0 && !scannerRootPositions.get(0)) {
            return -1;
        }
        return severity;
    }

    @NotNull
    @Override
    String getDefaultInput() {
        return MyInput.DAY13.getInput();
    }
}