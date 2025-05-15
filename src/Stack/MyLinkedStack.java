package Stack;

import Interface.StackADT;
import List.IntLinkedList;

public class MyLinkedStack implements StackADT {
    private IntLinkedList list;

    public MyLinkedStack() {
        list = new IntLinkedList();
    }


    // Pushes a value onto the top of the stack
    public void push(int x) {
        list.addFirst(x);
    }


    // Pops and returns the top value from the stack
    public int pop() throws Exception {
        return list.removeFirst();
    }


    // Checks if the stack is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }


    // Returns the number of elements currently in the stack
    public int size() {
        return list.size();
    }


    // Displays the contents of the stack from top to bottom
    public void display() {
        list.display();
    }
}