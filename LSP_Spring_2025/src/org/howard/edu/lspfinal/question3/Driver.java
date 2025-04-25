package org.howard.edu.lspfinal.question3;

/**
 * Tests the use of the report classes.
 */
public class Driver {
    public static void main(String[] args) {
        Report salesReport = new SalesReport();
        salesReport.generateReport();

        System.out.println(); 

        Report inventoryReport = new InventoryReport();
        inventoryReport.generateReport();
    }
}
