# Polynomials 
## Introduction
This is a simple package for working with polynomials in Java. It provides a class `Polynomial ` that represents a polynomial and supports basic operations like addition, subtraction, multiplication, and evaluation.
This project was created as part of the course "Data Structures in Java" at the University of Alexandria.


## Usage
Here is an example of how you can use this package to work with polynomials:

```java
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
```

This will output:

```
Sum of -1 - 1x and 1 + 0x + 1x^2 is:  1 + 0x + 1x^2
Difference of -1 - 1x and 1 + 0x + 1x^2 is:  -2 - 1x - 1x^2
Product of -1 - 1x and 1 + 0x + 1x^2 is:  -1 - 1x - 1x^2 + 0x^2 - 1x^3
The derivative of 2 + 1x is:  0 + 2x
The integral of 1 - 3x - 5 is:  1x - 1.5x^2 - 5x + c
The evaluation of 1 - 3x - 5 at x=2 is:  -12
```



