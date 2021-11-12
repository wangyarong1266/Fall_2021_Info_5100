package edu.northeastern.hw4;

public class Question1 {

    public static void main(String[] args) throws Exception {
        LinkedList test = new ThreadSafeLinkedList();
        test.print();
        test.addAtPosition(0, 5);
        test.addAtPosition(1, 6);
        test.addAtPosition(0, 3);
        System.out.println(test.getFirst());
        System.out.println(test.size());
        test.print();

        test.removeAtPosition(100, 2);
        test.removeAtPosition(1, 5);
        test.print();
        System.out.println(test.size());
        System.out.println(test.getLast());

        Runnable worker1 = () -> test.addAtPosition(0, 4);
        Runnable worker2 = () -> test.addAtPosition(0, 3);

        Thread thread1 = new Thread(worker1);
        Thread thread2 = new Thread(worker2);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        test.print();
    }
}

interface LinkedList {
    void addAtPosition(int index, int element);

    void removeAtPosition(int index, int element);

    int getFirst();

    int getLast();

    int size();

    void print();
}

class ThreadSafeLinkedList implements LinkedList {

    private ListNode dummy;
    private ListNode tail;
    private int size;

    ThreadSafeLinkedList() {
        dummy = new ListNode(0);
        tail = dummy;
        size = 0;
    }

    @Override
    public synchronized void addAtPosition(int index, int element) {
        if (index < 0 || index > size) {
            System.out.println("Cannot insert at " + index);
            return;
        }
        ListNode add = new ListNode(element);
        ListNode prev = getPrevNode(index);
        add.next = prev.next;
        prev.next = add;
        if (add.next == null) {
            tail = add;
        }
        size++;
    }

    @Override
    public synchronized void removeAtPosition(int index, int element) {
        if (index < 0 || index > size - 1) {
            System.out.println("Cannot remove at " + index);
            return;
        }
        ListNode prev = getPrevNode(index);
        ListNode remove = prev.next;
        prev.next = remove.next;
        remove.next = null;
        if (prev.next == null) {
            tail = prev;
        }
        size--;
    }

    @Override
    public synchronized int getFirst() {
        if (size == 0) {
            System.out.println("The linkedlist is empty!");
            return Integer.MIN_VALUE;
        }
        return dummy.next.value;
    }

    @Override
    public synchronized int getLast() {
        if (size == 0) {
            System.out.println("The linkedlist is empty!");
            return 0;
        }
        return tail.value;
    }

    @Override
    public synchronized int size() {
        return size;
    }

    @Override
    public synchronized void print() {
        if (dummy.next == null) {
            System.out.println("Empty list!");
            return;
        }

        System.out.print("The list is: ");
        ListNode cur = dummy.next;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    private ListNode getPrevNode(int index) {
        if (index == 0) {
            return dummy;
        }
        ListNode cur = dummy;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur;
    }

    private class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
