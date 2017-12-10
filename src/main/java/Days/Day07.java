package Days;

import Days.tools.Node;
import Days.tools.SupremeTree;
import org.jetbrains.annotations.NotNull;

/**
 * <p>
 * solution part one: mwzaxaj
 * <p>
 * solution part two: 1219
 *
 * @see <a href="http://adventofcode.com/2017/day/7">Advent of Code: Day 7</a>
 */
public class Day07 extends Day {

    public Day07() {
        System.out.println("\n--- Day 7: Recursive Circus ---");
        // input
        SupremeTree supremeTree = new SupremeTree(readLinesToString());
        // wörk
        findRoot(supremeTree);
        findCorrectWeight(supremeTree);
        System.out.println();
        // finished
    }

    public static void main(String[] args) {
        new Day07();
    }

    private void findRoot(SupremeTree supremeTree) {
        Node node = supremeTree.getRoot();
        System.out.println("Solution Part One:");
        System.out.println("\t" + node.getLabel());
    }

    private void findCorrectWeight(SupremeTree tree) {
        int newWeight = tree.findCorrectWeigth();
        System.out.println("Solution Part Two:");
        System.out.println("\t" + newWeight);
    }

    @NotNull
    @Override
    String getDefaultInput() {
        return MyInput.DAY07.getInput();
    }
}