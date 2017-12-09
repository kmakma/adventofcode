package Days.tools;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SupremeTree {

    private List<Node> nodes = new ArrayList<>();
    private Node root;

    public SupremeTree(String input) {
        List<String[]> splitInput = splitInput(input);
        if (splitInput != null) {
            parseInput(splitInput);
        }
        updateRoot();
    }

    private void updateRoot() {
        Node node = nodes.get(0);
        while (node.getParent() != null) {
            node = node.getParent();
        }
        root = node;
    }

    private void parseInput(List<String[]> splitInput) {
        Map<String, Integer> newNodes = new HashMap<>();
        Map<String, String[]> newConnections = new HashMap<>();
        for (String[] inputLine : splitInput) {
            newNodes.put(inputLine[0], parseWeight(inputLine[1]));
            if (inputLine.length > 2) {
                newConnections.put(inputLine[0], parseChildren(inputLine[2]));
            }
        }
        addNodes(newNodes);
        addConnections(newConnections);
    }

    @NotNull
    private String[] parseChildren(String children) {
        return children.trim().replace("-> ", "").split(", ");
    }

    @NotNull
    private Integer parseWeight(String weightString) {
        String weight = weightString.replace("(", "").replace(")", "");
        return Integer.valueOf(weight);
    }

    @Nullable
    private List<String[]> splitInput(String input) {
        BufferedReader br = new BufferedReader(new StringReader(input));
        String line;
        List<String[]> splitLines = new ArrayList<>();
        do {
            try {
                line = br.readLine();
            } catch (IOException e) {
                System.err.println("SupremeTree: IOException while reading string.");
                return null;
            }
            if (line == null) {
                break;
            }
            String[] splitLine = line.trim().split(" ", 3);
            if (splitLine.length >= 2) {
                splitLines.add(splitLine);
            }
        } while (!"".equals(line));

        return splitLines;
    }

    private void addNodes(Map<String, Integer> nodesMap) {
        for (Map.Entry<String, Integer> node : nodesMap.entrySet()) {
            nodes.add(new Node(node));
        }
    }

    private void addConnections(Map<String, String[]> connections) {
        for (Map.Entry<String, String[]> connection : connections.entrySet()) {
            Node parent = getNode(connection.getKey());
            Node[] children = getNodes(connection.getValue());
            if (parent != null) {
                parent.setChildren(children);
            }
            for (Node child : children) {
                child.setParent(parent);
            }
        }
    }

    @NotNull
    private Node[] getNodes(String[] childrenStrings) {
        Node[] children = new Node[childrenStrings.length];

        for (Node node : nodes) {
            for (int i = 0; i < childrenStrings.length; i++) {
                if (node.getLabel().equals(childrenStrings[i])) {
                    children[i] = node;
                }
            }
        }
        return children;
    }

    private Node getNode(String nodeString) {
        for (Node node : nodes) {
            if (node.getLabel().equals(nodeString)) {
                return node;
            }
        }
        return null;
    }

    public Node getRoot() {
        return root;
    }


    public int findCorrectWeigth() {
        Node parent = findParentOfBadChild();

        int[] childrenWeights = getTotalWeightsOf(parent.getChildren());
        int targetWeight = findTargetWeigth(childrenWeights);
        Node badChild = null;
        for (int i = 0; i < childrenWeights.length; i++) {
            if (childrenWeights[i] != targetWeight) {
                badChild = parent.getChildren()[i];
                break;
            }
        }
        return getCorrectWeightOf(badChild, targetWeight);
    }

    private int getCorrectWeightOf(Node badChild, int targetWeight) {
        int childrenWeight = badChild.getTotalWeight() - badChild.getWeight();
        return targetWeight - childrenWeight;
    }

    private Node findParentOfBadChild() {
        Node parent = root;
        Node badChild = root;
        //noinspection ConstantConditions
        while (badChild.hasChildren()) {
            parent = badChild;
            badChild = findBadChild(parent.getChildren());
            if (badChild.equals(parent)) {
                return parent.getParent();
            }
        }
        return parent;
    }

    private Node findBadChild(Node[] children) {
        int[] childrenWeights = getTotalWeightsOf(children);
        int targetWeight = findTargetWeigth(childrenWeights);
        for (int i = 0; i < childrenWeights.length; i++) {
            if (childrenWeights[i] != targetWeight) {
                return children[i];
            }
        }
        return children[0].getParent();
    }

    private int findTargetWeigth(int[] weights) {
        for (int i = 0; i < weights.length - 1; i++) {
            if (weights[i] == weights[i + 1]) {
                return weights[i];
            }
        }
        return 0;
    }

    private int[] getTotalWeightsOf(Node[] nodes) {
        int[] nodeWeights = new int[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            nodeWeights[i] = nodes[i].getTotalWeight();
        }
        return nodeWeights;
    }
}
