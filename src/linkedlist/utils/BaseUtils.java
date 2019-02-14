package linkedlist.utils;

import linkedlist.nodes.Node;

public abstract class BaseUtils {
    private Node head;
    private Node end;

    public abstract Node getHead();

    public abstract Node getEnd();

    public abstract Node reverseLinkedList(Node node);
}
