package com.adventofcode.day7.part2;

import com.adventofcode.day7.Node;

import java.util.List;
import java.util.Map;

import static com.adventofcode.day7.NodeUtils.createEmptyNodes;
import static com.adventofcode.day7.NodeUtils.populateNodes;

public class Solution {
    public int count(List<String> inputLines) {
        final Map<String, Node> nodes = createEmptyNodes(inputLines);

        populateNodes(inputLines, nodes);

        final var myBag = nodes.get("shiny gold");

        return countChildren(myBag) - 1;
    }

    private int countChildren(Node myBag) {
        if (myBag.getChildren().isEmpty())
            return 1;

        int count = 1;
        for (Node child : myBag.getChildren().keySet()) {
            final var childNr = myBag.getChildren().get(child);
            count += childNr * countChildren(child);

        }

        return count;
    }
}
