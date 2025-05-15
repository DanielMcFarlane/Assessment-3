public class Main {
    public static void main(String[] args) throws Exception {
        Stack.MyStack aStack = new Stack.MyStack();

        System.out.println("Testing stack");
        System.out.println("Stack is empty: " + aStack.isEmpty());

        for (int i = 1; i < 6; i++) {
            aStack.push(i); // Push values 1 to 5
        }

        System.out.println("\nNumber of values in stack: " + aStack.size());

        aStack.display(); // Display contents of stack

        System.out.println("\nPopping value " + aStack.pop() + "\nValue 5 should have been removed");

        aStack.display(); // Display stack after pop
    }
}