package org.howard.edu.lsp.assignment2;

import java.io.*;

public class ETLPipeline {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {

            // Skip the header line from the input CSV
            br.readLine();       //lines 8-16 from https://youtu.be/-Aud0cDh-J8?si=WnyFkAXSoFJebHHC
	}

}
	//lines 20-33 idea from https://stackoverflow.com/questions/32171744/how-to-have-a-range-of-numbers-in-an-if-else-statement-java
	public static String PriceRange(double price) {
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