package com.adventofcode.day7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class Node {
    private String color;
    private Map<Node, Integer> children;
    private Set<Node> parents;

    public Node(String color) {
        this.color = color;
        children = new HashMap<>();
        parents = new HashSet<>();
    }

    public void addChildren(Node child, int count) {
        children.put(child, count);
        child.addParent(this);
    }

    public void addParent(Node parent) {
        parents.add(parent);
    }

    public String getColor() {
        return color;
    }

    public Map<Node, Integer> getChildren() {
        return children;
    }

    public Set<Node> getParents() {
        return parents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return color.equals(node.color);
    }

    @Override
    public int hashCode() {
        return color.hashCode();
    }

    @Override
    public String toString() {
        return "Node{" + "color='" + color + '\'' + '}';
    }
}
