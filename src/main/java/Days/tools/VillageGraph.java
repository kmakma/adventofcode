package Days.tools;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static Days.tools.Tools.splitInput;

public class VillageGraph {

    private List<Villager> villagers;

    public VillageGraph(String input) {
        List<String[]> splitInput = splitInput(input);
        if (splitInput != null) {
            villagers = new ArrayList<>(splitInput.size());
            parseInput(splitInput);
        }
    }

    private void parseInput(List<String[]> splitInput) {
        for (String[] strings : splitInput) {
            Villager currentV = getVillager(Integer.parseInt(strings[0]));
            Villager[] neighbours = parseNeighbours(strings[2]);
            currentV.setNeighbours(neighbours);
        }
    }

    private Villager[] parseNeighbours(String string) {
        String[] splitString = string.split(", ");
        Villager[] neighbours = new Villager[splitString.length];
        for (int i = 0; i < splitString.length; i++) {
            neighbours[i] = getVillager(Integer.parseInt(splitString[i]));
        }
        return neighbours;
    }

    private Villager getVillager(int label) {
        for (Villager villager : villagers) {
            if (villager.getLabel() == label) {
                return villager;
            }
        }
        Villager villager = new Villager(label);
        villagers.add(villager);
        return villager;
    }

    public Set<Villager> getNeighbourhoodOf(int label) {
        Set<Villager> neighbourhood = new HashSet<>();
        findNeighbours(getVillager(label), neighbourhood);
        return neighbourhood;
    }

    private void findNeighbours(Villager villager, Set<Villager> neighbourhood) {
        neighbourhood.add(villager);
        Villager[] neighbours = villager.getNeighbours();
        for (Villager neighbour : neighbours) {
            if (!neighbourhood.contains(neighbour)) {
                findNeighbours(neighbour, neighbourhood);
            }
        }
    }
}
