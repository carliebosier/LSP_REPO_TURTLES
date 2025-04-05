package org.howard.edu.assignment6;

/**
 * Custom exception class for IntegerSet operations.
 * Websites used: https://www.baeldung.com/java-new-custom-exception and https://mkyong.com/java/java-custom-exception-examples/
 */
public class IntegerSetException extends Exception {

    public IntegerSetException(String message) {
        super(message);
    }
}
