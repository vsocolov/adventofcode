package com.adventofcode.day7;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class NodeUtils {
    public static Map<String, Node> createEmptyNodes(List<String> inputLines) {
        final Map<String, Node> nodes = new HashMap<>();

        for (String inputLine : inputLines) {
            final var color = getBagColor(inputLine);
            final var node = new Node(color);
            nodes.put(color, node);
        }

        return nodes;
    }

    public static String getBagColor(final String input) {
        int colorIndex = input.indexOf("contain") - 6;
        return input.substring(0, colorIndex);
    }

    public static void populateNodes(List<String> inputLines, Map<String, Node> nodes) {
        for (String inputLine : inputLines) {
            final var bagColor = getBagColor(inputLine);
            final var bag = nodes.get(bagColor);

            final String rightString = inputLine.substring(inputLine.indexOf("contain") + 8);
            final var dirtyChildColors = rightString.split(",");
            for (String dirtyChildColor : dirtyChildColors) {
                final var dirtyChild = dirtyChildColor.replaceAll("bags.|bags|bag.|bag", StringUtils.EMPTY).trim();
                if (!dirtyChild.equalsIgnoreCase("no other")) {
                    final int blankSpaceIndex = dirtyChild.indexOf(" ");
                    final var childColor = dirtyChild.substring(blankSpaceIndex + 1);
                    final var childNr = Integer.parseInt(dirtyChild.substring(0, blankSpaceIndex));

                    final var child = nodes.get(childColor);
                    bag.addChildren(child, childNr);
                }
            }
        }
    }
}
