package org.howard.edu.lsp.midterm.question3;

import java.util.ArrayList;
import java.util.List; 

/**
 * simulates a voting machine that allows casting votes and determines winner of election 
 */
public class VotingMachine {
    private List<Candidate> candidates;

    /**
     * Constructs a VotingMachine with an empty list of candidates
     * much of the code is based from the book and IntegerSet classes 
     */
    public VotingMachine() {
        candidates = new ArrayList<>();
    }
    
    //adds candidate name
    public boolean addCandidate(String name) {
        for (Candidate candidate : candidates) {
            if (candidate.getName().equals(name)) {
                return false; //returns false if candidate already exists
            }
        }
        candidates.add(new Candidate(name));
        return true;
    }

    //casts the vote for the candidate 
    public boolean castVote(String name) {
        for (Candidate candidate : candidates) {
            if (candidate.getName().equals(name)) {
                candidate.incrementVotes();
                return true;
            }
        }
        return false; //returns false if candidate does not exist
    }

    //returns the number of votes for a candidate 
    public int getVotes(String name) {
        for (Candidate candidate : candidates) {
            if (candidate.getName().equals(name)) {
                return candidate.getVotes();
            }
        }
        return -1; //returns -1 (false) if candidate does not exist 
    }

    	//returns winner of vote 
    public String getWinner() {
        if (candidates.isEmpty()) {
            return "No candidates available.";
        }
        Candidate winner = candidates.get(0);
        for (Candidate candidate : candidates) {
            if (candidate.getVotes() > winner.getVotes()) {
                winner = candidate;
            }
        }
        return winner.getName() + " WINS with " + winner.getVotes() + " votes!!";
    }

    /**
     * Creates the candidate in the election.
     */
    public class Candidate {
        private String name;
        private int votes;

        /**
         * Construct class that creates a candidate with the given name
         * @param name of the candidate 
         */
        public Candidate(String name) {
            this.name = name;
            this.votes = 0;
        }

        //returns name of candidate
        public String getName() {
            return name;
        }

        //returns the number of votes 
        public int getVotes() {
            return votes;
        }

        //adds a vote to the candidate based on how many times they were voted for 
        public void incrementVotes() {
            votes++;
        }
    }
}