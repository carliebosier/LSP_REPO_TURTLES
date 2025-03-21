package org.howard.edu.lsp.midterm.question3;

/**
 * Test driver for the VotingMachine class
 * runs a series of tests such as adding candidates, casting votes, checks for non-existent candidates, displays winner
 */
public class VotingMachineTest {
	public static void main(String[] args) {
        VotingMachine vm = new VotingMachine();
        
        //Add candidates
        System.out.println(vm.addCandidate("Alice")); 
        System.out.println(vm.addCandidate("Bob"));   
        System.out.println(vm.addCandidate("Charlie")); 

        //Casting votes
        System.out.println(vm.castVote("Alice")); 
        System.out.println(vm.castVote("Alice")); 
        System.out.println(vm.castVote("Bob"));    
        System.out.println(vm.castVote("Charlie")); 
        System.out.println(vm.castVote("Charlie"));
        System.out.println(vm.castVote("Charlie")); 

        //Attempt to vote for a non-existent candidate
        boolean success = vm.castVote("Eve");
        System.out.println("Vote for Eve successful? " + success); 

        //Displaying Results 
        System.out.println(vm.getWinner()); 
	}
}