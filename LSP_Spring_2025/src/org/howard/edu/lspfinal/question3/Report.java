package org.howard.edu.lspfinal.question3;

/**
 * Abstract class defining the template for generating reports. 
 * Template design pattern reference: https://www.baeldung.com/java-template-method-pattern  &  https://www.geeksforgeeks.org/template-method-design-pattern/  &  https://refactoring.guru/design-patterns/template-method
 */
public abstract class Report {

    /**
     * Template method for generating a report.
     * Defines the steps in the report generation process.
     */
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    /**
     * Loads data for the report.
     */
    protected abstract void loadData();

    /**
     * Formats the loaded data.
     */
    protected abstract void formatData();

    /**
     * Prints the final report.
     */
    protected abstract void printReport();
}
