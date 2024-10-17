package org.example;

public class Position3DNode {
    private Position3D data;
    private Position3DNode link;

    public Position3DNode(Position3D initialData, Position3DNode initialLink) {
        data = initialData;
        link = initialLink;
    }

    public void setData(Position3D newData) {
        data = newData;
    }

    public Position3D getData() {
        return data;
    }

    public Position3DNode getLink() {
        return link;
    }

    public void setLink(Position3DNode newLink) {
        link = newLink;
    }

    public static Position3DNode listSearch(Position3DNode head, Position3D target) {
        Position3DNode cursor;

        for (cursor = head; cursor != null; cursor = cursor.link)
            if (target.compareTo(cursor.data) == 0)
                return cursor;

        return null;
    }

    // O(N) Complexity
    public static Position3DNode listPosition(Position3DNode head, int position) {
        Position3DNode cursor;
        int i;

        if (position <= 0)
            throw new IllegalArgumentException("position is not positive");
        cursor = head;
        for (i = 1; (i < position) && (cursor != null); i++)
            cursor = cursor.link;

        return cursor;
    }
}
