package org.howard.edu.lsp.midterm.question2;

/**
 * tests the functionality of the book class by creating instances of book
 */
public class BookDriver {
	
	/**
	 * creates 3 books and tests the book class by comparing the books and returning the string representation 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789", 1925);
        Book book3 = new Book("A Promised Land", "Barack Obama", "9780593239681", 2020);

        // Test equals() method
        System.out.println(book1.equals(book2)); //if works it should output true
        System.out.println(book1.equals(book3));  //if code works it should output false 

        // Test toString() method
        System.out.println(book1); //outputs the information of book1
	}
}
