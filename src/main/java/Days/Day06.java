package Days;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * solution part one: 3156
 * <p>
 * solution part two: 1610
 *
 * @see <a href="http://adventofcode.com/2017/day/10">Advent of Code: Day 10</a>
 */
public class Day06 extends Day {

    public Day06() {
        System.out.println("\n--- Day 6: Memory Reallocation ---");
        // input
        String input = readLine();
        // wörk
        List<Integer> inputList = parseInput(input);
        if (inputList != null && !input.isEmpty()) {
            detectLoopAndSize(inputList);
        }
        System.out.println();
        // finished
    }

    public static void main(String[] args) {
        new Day06();
    }


    private void detectLoopAndSize(List<Integer> inputList) {
        Set<List<Integer>> knownLists = new LinkedHashSet<>();
        List<Integer> list = new ArrayList<>(inputList);
        while (knownLists.add(new ArrayList<>(list))) {
            int max = Collections.max(list);
            redistributeIndex(list.indexOf(max), list);
        }

        System.out.println("Solution Part One:");
        System.out.println("\t" + knownLists.size());

        List<List<Integer>> knownListsList = new ArrayList<>(knownLists);
        int indexLoopStart = knownListsList.indexOf(list);
        System.out.println("Solution Part Two:");
        System.out.println("\t" + (knownLists.size() - indexLoopStart));
    }

    private void redistributeIndex(int index, List<Integer> list) {
        int redistribute = list.set(index, 0);
        int currentIndex = normalizeIndex(index + 1, list.size());
        for (; redistribute > 0; redistribute--) {
            list.set(currentIndex, list.get(currentIndex) + 1);
            currentIndex = normalizeIndex(currentIndex + 1, list.size());
        }
    }

    private List<Integer> parseInput(String input) {
        String[] splitInput;
        if (input.contains("\t")) {
            splitInput = input.split("\t");
        } else {
            splitInput = input.split(" ");
        }
        List<Integer> list = new ArrayList<>();
        for (String intString : splitInput) {
            try {
                list.add(Integer.valueOf(intString));
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return list;
    }

    @NotNull
    @Override
    String getDefaultInput() {
        return MyInput.DAY06.getInput();
    }
}