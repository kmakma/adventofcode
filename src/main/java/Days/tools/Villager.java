package Days.tools;

public class Villager {
    private int label;
    private Villager[] neighbours;

    Villager(int label) {
        this.label = label;
    }

    void setNeighbours(Villager[] neighbours) {
        this.neighbours = neighbours;
    }

    public Villager[] getNeighbours() {
        return neighbours;
    }

    public int getLabel() {
        return label;
    }
}
