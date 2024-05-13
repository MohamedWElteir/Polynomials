package DataStructures;


public class Node {
    int coefficient, exponent;
    Node next;

    Node(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        next = null;
    }

    // constructor for constants "isn't used yet..."
    Node(int coefficient) {
        this.coefficient = coefficient;
        this.exponent = 0;
    }
}
