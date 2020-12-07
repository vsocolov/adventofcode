package com.adventofcode.day7.part1;

import com.adventofcode.day7.Node;

import java.util.*;

import static com.adventofcode.day7.NodeUtils.createEmptyNodes;
import static com.adventofcode.day7.NodeUtils.populateNodes;

public class Solution {

    public int count(List<String> inputLines) {
        final Map<String, Node> nodes = createEmptyNodes(inputLines);

        populateNodes(inputLines, nodes);

        final var myBag = nodes.get("shiny gold");

        return countParents(myBag);
    }

    private int countParents(Node myBag) {
        if (myBag.getParents().isEmpty())
            return 0;

        int count = 0;
        final Stack<Node> nodesStack = new Stack<>();
        final Set<Node> processedNodes = new HashSet<>();
        processedNodes.add(myBag);
        nodesStack.addAll(myBag.getParents());

        while (!nodesStack.isEmpty()) {
            final var parentBag = nodesStack.pop();
            if (!processedNodes.contains(parentBag)) {
                count++;
                processedNodes.add(parentBag);
                nodesStack.addAll(parentBag.getParents());
            }
        }

        return count;
    }
}
