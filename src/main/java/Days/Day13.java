package Days;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * solution part one: 1928
 * <p>
 * solution part two: ___
 *
 * @see <a href="http://adventofcode.com/2017/day/13">Advent of Code: Day 13</a>
 */
public class Day13 extends Day {

    private Map<Integer, Integer> scannerRanges;
    private Map<Integer, Integer> scannerPositions;
    private Map<Integer, Integer> scannerDirections;
    private int currentDepth;
    private int severity = -1;
    private boolean caught;

    public Day13() {
        System.out.println("\n--- Day13: Packet Scanners ---");
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
        initializeScanners();
        checkTripSeverity();
        System.out.println("Solution Part One:");
        System.out.println("\t" + severity);
    }

    private void calculateDelayTime() {
        int delay = -1;
        severity = -1;
        boolean caught = false;
        while (severity != 0 || caught) {
            delay++;
            initializeScanners();
            delayBy(delay);
            caught = checkTripSeverity();
            if(severity== 0) {
                System.out.println("severity:"+severity+"caught:"+caught);
            }
            if(!caught) {
                System.out.println("severity:"+severity+"*caught*:"+caught);
            }
        }
        System.out.println("Solution Part Two:");
        System.out.println("\t" + delay);
    }

    private void delayBy(int delay) {
        for (int i = 0; i < delay; i++) {
            moveScanners();
        }
    }

    private boolean checkTripSeverity() {
        int depth = Collections.max(scannerRanges.keySet());
        currentDepth = -1;
        severity = 0;
        caught = false;
        for (int i = 0; i <= depth; i++) {
            currentDepth++;
            checkSeverity();
            moveScanners();
        }
        return caught;
    }

    private void initializeScanners() {
        scannerPositions = new HashMap<>();
        scannerDirections = new HashMap<>();
        for (int scannerDepth : scannerRanges.keySet()) {
            scannerPositions.put(scannerDepth, 0);
            scannerDirections.put(scannerDepth, 1);
        }
    }

    private void moveScanners() {
        for (int scannerDepth : scannerPositions.keySet()) {
            int newPos = scannerPositions.get(scannerDepth) + scannerDirections.get(scannerDepth);
            scannerPositions.put(scannerDepth, newPos);
            if (newPos == scannerRanges.get(scannerDepth) - 1) {
                scannerDirections.put(scannerDepth, -1);
            } else if (newPos == 0) {
                scannerDirections.put(scannerDepth, 1);
            }
        }
    }

    private void checkSeverity() {
        int scannerPosition = scannerPositions.getOrDefault(currentDepth, -1);
        if (scannerPosition == 0) {
            severity += currentDepth * scannerRanges.get(currentDepth);
            caught = true;
        }
    }

    @NotNull
    @Override
    String getDefaultInput() {
        return MyInput.DAY13.getInput();
    }
}