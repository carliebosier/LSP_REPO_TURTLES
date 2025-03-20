package org.howard.edu.lsp.midterm.question2;

/**
 * represents the books in a library system.  the class maintains the details of the books.
 */
public class Book {
	private String title;
	private String author;
	private String ISBN;
	private int yearPublished; 
/**
 * construct class that creates a new book based on the details of parameters 
 * @param title	of the book
 * @param author of the book
 * @param ISBN of the book 
 * @param yearPublished the year the book was published 
 */
	// Constructor
    public Book(String title, String author, String ISBN, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
    }

    //returns the title of the book
    public String getTitle() {
        return title;
    }
    
    //sets the title of the book
    public void setTitle(String title) {
        this.title = title;
    }
    
    //returns the author of the book
    public String getAuthor() {
        return author;
    }

    //sets the author of the book 
    public void setAuthor(String author) {
        this.author = author;
    }
    
    //returns the ISBN of the book
    public String getISBN() {
        return ISBN;
    }
    
    //sets the ISBN of the book 
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    //returns the year the book was published 
    public int getYearPublished() {
        return yearPublished;
    }
    
    //sets the year the book was published 
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }
    
    //Compares this book to the other book and returns true if it is the same (including details) otherwise returns false.
    @Override
    public boolean equals(Object obj) {  //websites used: https://hmkcode.com/java/java-overriding-equals-methods-of-object-class/ and https://www.geeksforgeeks.org/overriding-equals-method-in-java/
        if (this == obj) {				//used code idea from assingment 5 
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return ISBN.equals(book.ISBN) && author.equals(book.author);
    }

    //returns a string representation of the book
    @Override
    public String toString() { //website used: https://www.geeksforgeeks.org/overriding-tostring-method-in-java/
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Year Published: " + yearPublished;
    }
}
