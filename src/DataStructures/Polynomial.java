package DataStructures;

public class Polynomial {
    public Node head;

    // default constructor
    public Polynomial(){
        head = null;
    }

    // basic constructor
    public Polynomial(Node head){
        this.head = head;
    }

    // fancy constructor: takes polyN string --> outputs polyN linkedLinked
    public Polynomial(String polynomial) {
        String[] terms = polynomial.split(" ");
        for (String term : terms) {
            String[] parts = term.split("x\\^");
            switch (parts.length) {
                case 2 -> {
                    int coefficient = Integer.parseInt(parts[0]);
                    int exponent = Integer.parseInt(parts[1]);
                    head = insert(coefficient, exponent);
                }
                case 1 -> {
                    // if it is a sign, ignore it
                    if (parts[0].equals("+") || parts[0].equals("-")) {
                        continue;
                    }
                    // Constants
                    int coefficient = Integer.parseInt(parts[0]);
                    head = insert(coefficient, 0);
                }
            }
        }
    }

    public String evaluate(Polynomial poly1, int x) {
        Node current = poly1.head;
        double result = 0;
        while (current != null) {
            result += current.coefficient * Math.pow(x, current.exponent);
            current = current.next;
        }
        return String.valueOf(result);
    }


    public Node insert(int coefficient, int exponent) {
        return insert(head, coefficient, exponent);
    }

    public Node insert(Node head, int coefficient, int exponent) {
        Node newNode = new Node(coefficient, exponent);
        // insert into an empty list AKA create a new linked-list
        if (head == null) {
            head = newNode;
        } else {
            // run over list and search for suitable place
            Node prev = null;
            Node curr = head;

            while (curr != null && curr.exponent > exponent) {
                prev = curr;
                curr = curr.next;
            }
            // found suitable place in list
            if (curr != null && curr.exponent == exponent) {
                curr.coefficient += coefficient;
            } else {
                // create a new place
                newNode.next = curr;
                if (prev != null) {
                    prev.next = newNode;
                } else {
                    head = newNode;
                }
            }
        }
        return head;
    }

    public Polynomial add(Polynomial poly1, Polynomial poly2) {
        Node result = null;
        Node head1 = poly1.head, head2 = poly2.head;
        // loop over the two polynomials
        while (head1 != null && head2 != null) {
            // exponent1 is bigger than exponent2
            if (head1.exponent > head2.exponent) {
                result = insert(result, head1.coefficient, head1.exponent);
                head1 = head1.next;
                // exponent2 is bigger than exponent1
            } else if (head1.exponent < head2.exponent) {
                result = insert(result, head2.coefficient, head2.exponent);
                head2 = head2.next;
                // both exponents are equal
            } else {
                result = insert(result, head1.coefficient + head2.coefficient, head1.exponent);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        // add remaining terms in polyN1
        while (head1 != null) {
            result = insert(result, head1.coefficient, head1.exponent);
            head1 = head1.next;
        }
        // add remaining terms in polyN2
        while (head2 != null) {
            result = insert(result, head2.coefficient, head2.exponent);
            head2 = head2.next;
        }

        return new Polynomial(result);
    }

    public Polynomial multiply(Polynomial poly1, Polynomial poly2) {
        Node result = null;
        Node head1 = poly1.head, head2 = poly2.head;

        // loop over one polyN
        while (head1 != null) {
            // multiply the current term with each term in the other polynomials
            while (head2 != null) {
                result = insert(result, head1.coefficient * head2.coefficient, head1.exponent + head2.exponent);
                head2 = head2.next;
            }
            head2 = poly2.head;
            head1 = head1.next;
        }
        return new Polynomial(result);
    }

    public Polynomial subtract(Polynomial poly1, Polynomial poly2) {
        // same logic as the add method
        Node result = null;
        Node temp1 = poly1.head, temp2 = poly2.head;

        while (temp1 != null && temp2 != null) {
            if (temp1.exponent > temp2.exponent) {
                result = insert(result, temp1.coefficient, temp1.exponent);
                temp1 = temp1.next;
            } else if (temp1.exponent < temp2.exponent) {
                result = insert(result, -temp2.coefficient, temp2.exponent);
                temp2 = temp2.next;
            } else {
                result = insert(result, temp1.coefficient - temp2.coefficient, temp1.exponent);
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }

        while (temp1 != null) {
            result = insert(result, temp1.coefficient, temp1.exponent);
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            result = insert(result, -temp2.coefficient, temp2.exponent);
            temp2 = temp2.next;
        }

        return new Polynomial(result);
    }

    public Polynomial differentiate(Polynomial poly) {
        Node result = null;
        Node currentTerm = poly.head;
        while (currentTerm != null) {
            // constant --> derivative = zero --> save memory and don't even keep track of it
            if (currentTerm.exponent == 0) {
                currentTerm = currentTerm.next;
                continue;
            }
            // (n-1)x^(n-1)
            result = insert(result, currentTerm.coefficient * currentTerm.exponent, currentTerm.exponent - 1);
            currentTerm = currentTerm.next;

        }
        return new Polynomial(result);
    }

    public Polynomial integrate(Polynomial poly) {
        Node result = null;
        Node currentTerm = poly.head;
        while (currentTerm != null) {
            // x^(n+1)/n+1
            result = insert(result, currentTerm.coefficient / (currentTerm.exponent + 1), currentTerm.exponent + 1);
            currentTerm = currentTerm.next;
        }
        return new Polynomial(result);
    }

    // to implement later,
    public double getX(Polynomial polynomial){
        double result = 0;

        return result;
    }


    @Override
public String toString() {
        StringBuilder sb = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            switch (temp.exponent) {
                // exp = 0 --> constant --> print coefficient only
                case 0 -> sb.append(temp.coefficient);
                // exp = 1 --> x^1 term --> print coefficient * x
                case 1 -> sb.append(temp.coefficient).append("x");
                // default case
                default -> sb.append(temp.coefficient).append("x^").append(temp.exponent);
            }
            // add "+" regardless as long as there are more terms to print
            if (temp.next != null) {
                sb.append(" + ");
            }
            temp = temp.next;
        }
        return sb.toString();
    }
}
