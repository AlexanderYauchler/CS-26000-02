package org.example;

import javax.swing.text.Position;
import java.util.Random;

public class Position3DLinkedBag {
    private Position3DNode head;
    private int manyNodes;

    public Position3DLinkedBag() {
        head = null;
        manyNodes = 0;
    }

    public void add(Position3D element) {
        head = new Position3DNode(element, head);
        manyNodes++;
    }

    public int countOccurrences(Position3D target) {
        int answer = 0;
        Position3DNode cursor;

        cursor = Position3DNode.listSearch(head, target);
        while (cursor != null) {
            answer++;
            cursor = cursor.getLink();
            cursor = Position3DNode.listSearch(cursor, target);
        }

        return answer;
    }

    public boolean remove(Position3D target) {
        Position3DNode targetNode = Position3DNode.listSearch(head, target);
        if (targetNode == null)
            return false;
        else {
            targetNode.setData(head.getData());
            head = head.getLink();
            manyNodes--;
            return true;
        }
    }

    public Position3D grab() {
        return Position3DNode.listPosition(head, new Random().nextInt(manyNodes) + 1).getData();
    }

    public int size() {
        return manyNodes;
    }
}
