package Days.tools;

import java.util.Map;

public class Node {
    private String label;
    private Node parent = null;
    private Node[] children = null;
    private int weight;
    private int totalWeight = -1;

    Node(String label) {
        this.label = label;
    }

    Node(Map.Entry<String, Integer> node) {
        this.label = node.getKey();
        weight = node.getValue();
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node[] getChildren() {
        return children;
    }

    void setChildren(Node[] children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object obj) {
        return label.equals(((Node) obj).getLabel());
    }

    public int getWeight() {
        return weight;
    }

    public String getLabel() {
        return label;
    }

    public int getTotalWeight() {
        if (totalWeight < 1) {
            totalWeight = weight;
            if (children != null) {
                for (Node child : children) {
                    totalWeight += child.getTotalWeight();
                }
            }
        }
        return totalWeight;
    }

    public boolean hasChildren() {
        return children != null && children.length >= 2;
    }
}