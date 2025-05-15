package Stack;

import Interface.StackADT;
import List.IntArrayList;

public class MyStack implements StackADT {
    private IntArrayList list;

    public MyStack() {
        list = new IntArrayList(20); // Limits the array to 20
    }

    // Pushes a value onto the stack if it's not full
    public void push(int value) {
        if (!isFull()) {
            list.add(value);
        } else {
            System.out.println("The stack is full.");
        }
    }

    // Pops the top value off the stack and returns it
    public int pop() {
        return list.delete();
    }

    // Checks whether the stack is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Checks if the stack is full
    public boolean isFull() {
        return list.isFull();
    }

    // Returns the current number of elements in the stack
    public int size() {
        return list.getCount();
    }

    // Displays the contents of the stack from top to bottom
    public void display() {
        System.out.print("Stack contents: ");

        int[] arr = list.getArray();

        for (int i = list.getCount() - 1; i >= 0; i--) { // Iterate from top to bottom
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}