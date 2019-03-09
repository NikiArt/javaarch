package ru.boiko.se.homeworkthree;

import java.util.NoSuchElementException;

public class MyArrayStack<Item> {
    private Object[] stack = new Object[1];
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity) {
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = stack[i];
        }
        stack = temp;
    }

    public void push(Item item) {
        if (size == stack.length) {
            resize(2 * stack.length);
        }
        stack[size++] = item;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        //unchecked
        return (Item) stack[size - 1];
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        Item item = (Item) stack[size - 1];
        size--;
        if (size == stack.length / 4 && size > 0) {
            resize(stack.length / 2);
        }
        return item;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = size - 1; i >= 0; i--) {
            s.append(((Item) stack[i]).toString());
            s.append(", ");
        }
        return s.toString();
    }
}