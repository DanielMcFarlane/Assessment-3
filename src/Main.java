public class Main {
    public static void main(String[] args) throws Exception {
        //
        // Stack
        //
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

        //
        // Linked list
        //
        Stack.MyLinkedStack bStack = new Stack.MyLinkedStack();

        System.out.println("\nTesting linked list");
        System.out.println("Linked list is empty: " + bStack.isEmpty());

        for (int i = 1; i < 6; i++) {
            bStack.push(i); // Push values 1 to 5
        }

        System.out.println("\nNumber of values in linked list: " + bStack.size());

        bStack.display(); // Display contents of linked stack

        System.out.println("\nPopping value " + bStack.pop() + "\nValue 5 should have been removed");

        bStack.display(); // Display linked stack after pop
    }
}