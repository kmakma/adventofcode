package Days;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * solution part one: 687
 * <p>
 * solution part two: 1483
 *
 * @see <a href="http://adventofcode.com/2017/day/11">Advent of Code: Day 11</a>
 */
public class Day11 extends Day {

    private int posY = 0;
    private int posX = 0;

    public Day11() {
        System.out.println("\n--- Day 11: Hex Ed ---");
        // input
        List<String> input = lineToStringList(",");
        // wörk
        findDistances(input);
        System.out.println();
        // finished
    }

    public static void main(String[] args) {
        new Day11();
    }

    private void findDistances(List<String> input) {
        int maxDistance = 0;
        for (String direction : input) {
            takeStep(direction);
            int currentDistance = getDistance();
            if(currentDistance>maxDistance) {
                maxDistance= currentDistance;
            }
        }
        System.out.println("Solution Part One:");
        System.out.println("\t" + getDistance());
        System.out.println("Solution Part Two:");
        System.out.println("\t" + maxDistance);
    }

    private int getDistance() {
        int distance = Math.abs(posX);
        if (Math.abs(posY) > Math.abs(posX)) {
            distance += (Math.abs(posY) - Math.abs(posX)) / 2;
        }
        return distance;
    }

    private void takeStep(String direction) {
        switch (direction) {
            case "nw":
                posY++;
                posX--;
                break;
            case "n":
                posY += 2;
                break;
            case "ne":
                posY++;
                posX++;
                break;
            case "s":
                posY -= 2;
                break;
            case "se":
                posY--;
                posX++;
                break;
            case "sw":
                posY--;
                posX--;
                break;
        }
    }

    @NotNull
    @Override
    String getDefaultInput() {
        return MyInput.DAY11.getInput();
    }
}