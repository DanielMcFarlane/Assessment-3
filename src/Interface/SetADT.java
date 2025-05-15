package Interface;

public interface SetADT {
    void add(Object o); // Adds an object to the set
    void remove(Object o); // Removes an object from the set
    void intersection(SetADT s); // Intersects the current set with another set
    void difference(SetADT s); // Computes the difference between the current set and another set
    int size(); // Returns the number of elements in the set
    boolean isEmpty(); // Checks if the set is empty
}
