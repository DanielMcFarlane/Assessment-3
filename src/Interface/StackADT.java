package Interface;

public interface StackADT {
    void push(int value); // Pushes an integer value onto the stack
    int pop() throws Exception; // Pops the top integer value off the stack
    boolean isEmpty(); // Checks if the stack is empty
    int size(); // Returns the number of elements in the stack
}
