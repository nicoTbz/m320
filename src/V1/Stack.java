package V1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterator<T> {
    private Node<T> top;            // Top of the stack
    private Node<T> current;        // Current node
    private Node<T> previous;       // last node given out by next()


    // Node class representing each element in the stack
    private static class Node<T> {
        T data;             // Data stored in the node
        Node<T> next;       // Reference to the next node

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor
    public Stack() {
        top = null;
        current = null;
        previous = null;
    }

    // Push an element onto the stack
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        current = top;
    }

    // Pop an element from the stack
    public T pop() {
        if (top == null) {
            throw new NoSuchElementException("Stack is empty.");
        }
        T data = top.data;
        top = top.next;
        current = top;

        return data;
    }

    // Check if there is a next element in the iteration
    @Override
    public boolean hasNext() {
        return current != null;
    }

    // Return the next element in the iteration
    @Override
    public T next() {
        if (current == null) {
            throw new NoSuchElementException();
        }
        T data = current.data;
        previous = current;
        current = current.next;

        return data;
    }

    // Remove the last element returned by next()
    @Override
    public void remove() {
        if (previous == null) {
            throw new IllegalStateException("next() has not been called or remove() already called after last next()");
        }
        if (previous == top) {
            pop();
            previous = null;
            return;
        }

        Node<T> temp = top;
        
        while (temp.next != previous) {
            temp = temp.next;
        }
        
        if (previous.next == null) {
            temp.next = null;
        }
        else {
            temp.next = previous.next;
        }
        
        current = top;
    }
}
