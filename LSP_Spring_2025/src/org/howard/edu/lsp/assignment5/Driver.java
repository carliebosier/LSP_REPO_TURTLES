package org.howard.edu.lsp.assignment5;

public class Driver {
	//Carlie Bosier
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerSet set1 = new IntegerSet(); //creating new IntegerSet1 and adding elements
		System.out.println("Adding elements to Set1");
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("Value of Set1: " + set1.toString());
        
        //smallest and largest operation 
        System.out.println("Smallest value in Set1: " + set1.smallest());
        System.out.println("Largest value in Set1: " + set1.largest());
        
        IntegerSet set2 = new IntegerSet(); //creating IntegerSet2 and adding elements 
        System.out.println("\nAdding elements to Set2");
        set2.add(3);
        set2.add(4);
        set2.add(5);
        System.out.println("Value of Set2: " + set2.toString());
        System.out.println("Smallest value in Set2: " + set2.smallest());
        System.out.println("Largest value in Set2: " + set2.largest());

        //union operation
        System.out.println("\nUnion of Set1 and Set2:");
        System.out.println("Value of Set1 before union: " + set1.toString());
        System.out.println("Value of Set2 before union: " + set2.toString());
        set1.union(set2);	//modifies set1
        System.out.println("Result of union of Set1 and Set2: " + set1.toString());
        
        set1.clear(); 	// Clear set1 after operation
        set1.add(1);    // Add the original values to set1 again
        set1.add(2);
        set1.add(3);

        //intersection operation 
        System.out.println("\nIntersection of Set1 and Set2:");
        System.out.println("Value of Set1 before intersection: " + set1.toString());
        System.out.println("Value of Set2 before intersection: " + set2.toString());
        set1.intersect(set2); 	//modifies set1
        System.out.println("Result of intersection of Set1 and Set2: " + set1.toString());
        
        set1.clear(); 	// Clear set1 after operation
        set1.add(1);    // Add the original values to set1 again
        set1.add(2);
        set1.add(3);
        
        //difference operation
        System.out.println("\nDifference of Set1 and Set2:");
        System.out.println("Value of Set1 before difference: " + set1.toString());
        System.out.println("Value of Set2 before difference: " + set2.toString());
        set1.diff(set2); 	//modifies set1
        System.out.println("Result of difference of Set1 and Set2: " + set1.toString());

        set1.clear(); 	// Clear set1 after operation
        set1.add(1);    // Add the original values to set1 again
        set1.add(2);
        set1.add(3);
        
        //complement operation
        System.out.println("\nComplement of Set1 relative to Set2:");
        System.out.println("Value of Set1 before complement: " + set1.toString());
        System.out.println("Value of Set2 before complement: " + set2.toString());
        set1.complement(set2); 		//modifies set1
        System.out.println("Result of complement of Set1: " + set1.toString());

        set1.clear(); 	// Clear set1 after operation
        set1.add(1);    // Add the original values to set1 again
        set1.add(2);
        set1.add(3);
        
        //remove operation
        System.out.println("\nRemoving an element from Set1:");
        System.out.println("Value of Set1 before remove: " + set1.toString());
        set1.remove(3);
        System.out.println("Value of Set1 after removing 3: " + set1.toString());

        set1.clear(); 	// Clear set1 after operation
        set1.add(1);    // Add the original values to set1 again
        set1.add(2);
        set1.add(3);
        
        //isEmpty operation
        System.out.println("\nTesting if Set1 is empty:");
        System.out.println("Is Set1 empty? " + set1.isEmpty());
        System.out.println("Is Set2 empty? " + set2.isEmpty());    
	}

}
