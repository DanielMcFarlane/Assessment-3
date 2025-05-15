package List;

public class IntLinkedList {
    class Node { //inner Node class only available to List.IntLinkedList class
        public int value; //value being stored
        public Node nextNode; //pointer to next node in list

        public Node(int value) { //creates a new node with that value
            this.value = value;
            nextNode = null;
        }

        public void add(int value) { //adds a new node to the end of the list
            if (nextNode == null)
                nextNode = new Node(value);
            else
                nextNode.add(value);
        }
    }//end class Node


    private Node start; //node at start of list
    private int count; //number of items in the list

    public IntLinkedList() { //default constructor
        start = null;
        count = 0;
    }


    public void addLast(int value) { //adds a value to the end of the list
        if (start == null) {
            start = new Node(value);
        } else {
            start.add(value);
        }
        count++;
    }


    public boolean isEmpty() { //returns true if list is empty
        return count == 0;
    }


    public void addFirst(int value) { //adds a value to the front of the list
        if (isEmpty()) {
            addLast(value);
        } else {
            Node temp = start;
            start = new Node(value);
            start.nextNode = temp;
            count++;
        }
    }


    public int removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked list is empty");
        }
        int removedValue = start.value;
        start = start.nextNode;
        count--;
        return removedValue;
    }


    public void display() { //displays the values in the list
        if (count == 0) {
            System.out.println("The linked list is empty");
        } else {
            System.out.print("Linked list contents: ");
            Node currentNode = start;
            while (currentNode != null) {
                System.out.print(currentNode.value + " ");
                currentNode = currentNode.nextNode;
            }//end while
            System.out.println();
        }//end if
    }//end display


    public int size() { //returns the number of items in the list
        return count;
    }//end size
}