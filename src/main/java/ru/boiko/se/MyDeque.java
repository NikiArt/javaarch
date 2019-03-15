package ru.boiko.se;

import java.util.NoSuchElementException;

public class MyDeque<Item> {
    private Object[] dequeue = new Object[1];
    private int size = 0;
    private int start = 0;
    private int end = 0;

    public MyDeque() {
    }

    public MyDeque(int capacity) {
        resize(capacity);
        size = capacity;
    }

    public MyDeque(Item[] dequeue) {
        this.dequeue = new Object[dequeue.length];
        for (int i = 0; i < dequeue.length; i++) {
            this.dequeue[i] = dequeue[i];
        }
        size = dequeue.length;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity) {
        final Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = dequeue[(start + i) % dequeue.length];
        }
        dequeue = temp;
        start = 0;
        end = size;
    }

    public void insertLeft(Item item) {
        if (size == dequeue.length) {
            resize(size * 2);
        }
        dequeue[start--] = item;
        if (start == -1) {
            start = dequeue.length - 1;
        }
        size++;
    }

    public void insertRight(Item item) {
        if (size == dequeue.length) {
            resize(size * 2);
        }
        dequeue[end++] = item;
        end %= dequeue.length;
        size++;
    }

    public Item removeLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty dequeue");
        }

        final Item item = (Item) dequeue[start];
        start = ++start > dequeue.length - 1 ? 0 : start;
        size--;

        if (size == dequeue.length / 4 && size > 0) {
            resize(dequeue.length / 2);
        }

        return item;
    }

    public Item removeRight() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty dequeue");
        }
        final Item item = (Item) dequeue[end--];
        if (end == -1) {
            end = dequeue.length - 1;
        }
        size--;
        if (size == dequeue.length / 4 && size > 0) {
            resize(dequeue.length / 2);
        }

        return item;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("MyDeque: ");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(dequeue[(start + i) % dequeue.length]);
            if (i < size - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

}
