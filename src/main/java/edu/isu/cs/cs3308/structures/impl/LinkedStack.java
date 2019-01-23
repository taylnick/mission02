package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Stack;

public class LinkedStack<E> implements Stack<E> {
    //create an instance of Doubly Linked List

    private DoublyLinkedList<E> dll;

    public LinkedStack(){
        dll = new DoublyLinkedList<>();
    }

    @Override
    public void push(E element) {
        if(element != null) dll.addFirst(element);
    }

    @Override
    public E peek() {
        if(dll.isEmpty()) return null;
        else return dll.get(0);
    }

    @Override
    public E pop() {
        if(dll.isEmpty()) return null;
        else return dll.removeFirst();
    }

    @Override
    public int size() {
        return dll.size();
    }

    @Override
    public boolean isEmpty() {
        return dll.isEmpty();
    }

    /**
     * Tranfers the contents of this stack into the provided stack. The contents
     * of this stack are to found in reverse order at the top of the provided
     * stack. This stack should be empty once the transfer is completed. Note
     * that if the provided stack is null, nothing is to happen.
     *
     * @param to The new stack onto which the reversed order of contents from
     * this stack are to be transferred to the top of, unless the provided stack
     * is null.
     */
    @Override
    public void transfer(Stack<E> to) {

    }

    @Override
    public void reverse() {

    }

    @Override
    public void merge(Stack<E> other) {

    }

    @Override
    public void printStack() {

    }
}