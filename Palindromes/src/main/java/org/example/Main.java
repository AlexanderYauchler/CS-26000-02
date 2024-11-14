package org.example;

public class Main {
    public static void main(String[] args) {
        String str = "saippuakivikauppias"; // Finnish word for soapstone vendoe
        ArrayQueue<Character> q = new ArrayQueue<>();
        ArrayQueue<Character> q2 = new ArrayQueue<>();
        ArrayStack<Character> s = new ArrayStack<>();
        System.out.println(str);

        for (int i = 0; i < str.length(); i++) {
            q.add(str.charAt(i));
            q2.add(str.charAt(i));
            s.push(str.charAt(i));
        }

        System.out.println("Queue size: " + q.size());

        // Test equals()
        System.out.println("The queues are equal: " + q.equals(q2));

        int res = 0;
        while (!q.isEmpty()) {
            if (q.remove() != s.pop())
                ++res;
        }

        // Test size()
        q.add('a');
        q.add('a');
        q.add('a');
        q.add('a');

        System.out.println("Queue size: " + q.size());
        System.out.println("The result is: " + res);
    }
}