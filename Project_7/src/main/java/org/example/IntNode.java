package org.example;

class IntNode {
    private int data;
    private IntNode link;

    public IntNode(int initialData, IntNode initialLink) {
        data = initialData;
        link = initialLink;
    }

    public void setData(int newData) {
        data = newData;
    }

    public int getData() {
        return data;
    }

    public IntNode getLink() {
        return link;
    }

    public void setLink(IntNode newLink) {
        link = newLink;
    }

    public static IntNode listSearch(IntNode head, int target) {
        IntNode cursor;
        for (cursor = head; cursor != null; cursor = cursor.link)
            if (target == cursor.data)
                return cursor;
        return null;
    }

    public static IntNode listPosition(IntNode head, int position) {
        IntNode cursor;
        int i;
        if (position <= 0)
            throw new IllegalArgumentException("position is not positive");
        cursor = head;
        for (i = 1; (i < position) && (cursor != null); i++)
            cursor = cursor.link;
        return cursor;
    }
}
