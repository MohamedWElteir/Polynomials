package Main;

import DataStructures.Polynomial;

import static DataStructures.Polynomial.*;


public class Main {
    public static void main(String[] args) {
        Polynomial polynomial1 = new Polynomial("-1x^0 - 1x^1");
        Polynomial polynomial2 = new Polynomial("1x^0 + 1x^2");
        Polynomial polynomial3 = new Polynomial("2x^2 + 1x^1");
        Polynomial polynomial4 = new Polynomial("1x^2 - 3x^1 - 5");

        System.out.println("Sum of " + polynomial1 + " and " + polynomial2 + " is:  " + add(polynomial1, polynomial2));
        System.out.println("Difference of " + polynomial1 + " and " + polynomial2 + " is:  " + subtract(polynomial1, polynomial2));
        System.out.println("Product of " + polynomial1 + " and " + polynomial2 + " is:  " + multiply(polynomial1, polynomial2));
        System.out.println("The derivative of " + polynomial3 + " is:  " + differentiate(polynomial3));
        System.out.println("The integral of " + polynomial4 + " is:  " + integrate(polynomial4)+" + c");
        System.out.println("The evaluation of " + polynomial4 + " at x=2 is:  " + evaluate(polynomial4, 2));


    }
}
