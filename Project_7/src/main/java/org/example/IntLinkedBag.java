package org.example;

import java.util.Random;

class IntLinkedBag implements Cloneable {
    private IntNode head;
    private int manyNodes;

    public IntLinkedBag() {
        head = null;
        manyNodes = 0;
    }

    public void add(int element) {
        head = new IntNode(element, head);
        manyNodes++;
    }

    public int countOccurrences(int target) {
        int answer;
        IntNode cursor;
        answer = 0;
        cursor = IntNode.listSearch(head, target);
        while (cursor != null) {
            answer++;
            cursor = cursor.getLink();
            cursor = IntNode.listSearch(cursor, target);
        }
        return answer;
    }

    public boolean remove(int target) {
        IntNode targetNode = IntNode.listSearch(head, target);
        if (targetNode == null)
            return false;
        else {
            targetNode.setData(head.getData());
            head = head.getLink();
            manyNodes--;
            return true;
        }
    }

    public int grab() {
        return IntNode.listPosition(head, new Random().nextInt(manyNodes) + 1).getData();
    }

    public int size() {
        return manyNodes;
    }
}
