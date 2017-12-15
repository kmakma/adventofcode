package Days;

import Days.tools.VillageGraph;
import Days.tools.Villager;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * solution part one: 145
 * <p>
 * solution part two: ___
 *
 * @see <a href="http://adventofcode.com/2017/day/12">Advent of Code: Day 12</a>
 */
public class Day12 extends Day {

    public Day12() {
        System.out.println("\n--- Day 12: Digital Plumber ---");
        // input
        VillageGraph village = new VillageGraph(readLinesToString());
        // wörk
        findNetworkSize(village);
        System.out.println();
        // finished
    }

    public static void main(String[] args) {
        new Day12();
    }

    private void findNetworkSize(VillageGraph village) {
        Set<Villager> neighbourhood = village.getNeighbourhoodOf(0);
        System.out.println("Solution Part One:");
        System.out.println("\t" + neighbourhood.size());
    }

    @NotNull
    @Override
    String getDefaultInput() {
        return MyInput.DAY12.getInput();
    }
}