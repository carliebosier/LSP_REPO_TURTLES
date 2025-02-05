package org.howard.edu.lsp.assignment2;

import java.io.*;

//Carlie Bosier

public class ETLPipeline {
	
	
	//lines 11-20 from https://youtu.be/-Aud0cDh-J8?si=WnyFkAXSoFJebHHC
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {

            br.readLine(); // Skip the header line from the input CSV
            
            
            bw.write("ProductID,Name,Price,Category,PriceRange"); //Write the new header to the output file
            bw.newLine();
            
            while ((line = br.readLine()) != null) {
            		if (line == null || line.trim().isEmpty()) {	//code idea from https://stackoverflow.com/questions/12556637/java-id-like-to-ignore-an-empty-line-when-reading-a-file
            			continue; 
            		}
            		String[] fields = line.split(",");
            		
            		int productID = Integer.parseInt(fields[0]);
            		String name = fields [1];
            		double price = Double.parseDouble(fields[2]);
            		String category = fields[3];
            		
            	
            if (category.equals("Electronics")) {
            	price = price * 0.9;  //applies the discount to the products in electronics category 
            	price = Math.round(price * 100.0) / 100.0; //rounding code from https://stackoverflow.com/questions/11701399/round-up-to-2-decimal-places-in-java
            	
            }
            name = name.toUpperCase();
            
            if (price > 500) {
            	category = "Premium Electronics";
            }
            String priceRange = priceRange(price);
            
            bw.write(productID + "," + name + "," + price + "," + category + "," + priceRange ); //writes the modified data to the output file 
            bw.newLine();
            }   
            System.out.println("ETL process complete. Check data folder."); 
	}
        //lines 50-  from https://www.geeksforgeeks.org/handle-an-ioexception-in-java/?ref=ml_lbp and https://studentofjava.blog/how-to-read-and-write-csv-files-in-java-a-step-by-step-guide/ and https://www.scaler.com/topics/ioexception-in-java/
        catch (FileNotFoundException e) {
        	System.err.println("ERROR: Input File is missing or inaccessible");
        }
        catch (IOException e) {
        	System.err.println("ERROR: An error occured while reading or writing files.");
        }

}
	//lines 20-33 idea from https://stackoverflow.com/questions/32171744/how-to-have-a-range-of-numbers-in-an-if-else-statement-java
	public static String priceRange(double price) {
	    if (price <= 10) {
	        // Prices from $0 to $10 are considered "Low"
	        return "Low";
	    } else if (price <= 100) {
	        // Prices from $10.01 to $100 are considered "Medium"
	        return "Medium";
	    } else if (price <= 500) {
	        // Prices from $100.01 to $500 are considered "High"
	        return "High";
	    } else {
	        // Prices above $500 are considered "Premium"
	        return "Premium";
	    }
	}
}