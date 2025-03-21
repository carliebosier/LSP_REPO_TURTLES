package org.howard.edu.lsp.midterm.question5;

/**
 * class that represents streamable content and their behaviors 
 */
public class StreamingService {

    //nested interface to include the different types of media used in this class
    interface Streamable { //website: https://www.w3schools.com/java/java_interface.asp and https://www.baeldung.com/java-inner-interfaces?utm_source=chatgpt.com
        void play();
        void pause();
        void stop();
    }

    //website for nested classes: https://www.geeksforgeeks.org/nested-classes-java/
    /**
     * concrete class for music that returns the music, pauses, and adds music to playlist 
     */
    class Music implements Streamable { 
        private String songName;

        public Music(String songName) {
            this.songName = songName;
        }

        @Override
        public void play() {
            System.out.println("Playing music: " + songName);
        }

        @Override
        public void pause() {
            System.out.println("Paused music: " + songName);
        }

        @Override
        public void stop() {
            System.out.println("Stopped music: " + songName);
        }

        //adds music to playlist
        public void addToPlaylist(String playlistName) {
            System.out.println("Added " + songName + " to " + playlistName + " playlist");
        }
    }

    /**
     * concrete class for movie that returns the movie, pauses, and rewinds
     */
    	class Movie implements Streamable {
        private String movieName;

        public Movie(String movieName) {
            this.movieName = movieName;
        }

        @Override
        public void play() {
            System.out.println("Playing movie: " + movieName);
        }

        @Override
        public void pause() {
            System.out.println("Paused movie: " + movieName);
        }

        @Override
        public void stop() {
            System.out.println("Stopped movie: " + movieName);
        }

        //rewinds
        public void rewind(int seconds) {
            System.out.println("Rewinding movie: " + movieName + " by " + seconds + " seconds");
        }
    }

    	/**
         * concrete class for audiobook that returns the book title, pauses, and adjusts the playback speed 
         */
    	class Audiobook implements Streamable {
        private String bookTitle;

        public Audiobook(String bookTitle) {
            this.bookTitle = bookTitle;
        }

        @Override
        public void play() {
            System.out.println("Playing audiobook: " + bookTitle);
        }

        @Override
        public void pause() {
            System.out.println("Paused audiobook: " + bookTitle);
        }

        @Override
        public void stop() {
            System.out.println("Stopped audiobook: " + bookTitle);
        }

        //sets playback speed
        public void setPlaybackSpeed(double speed) {
            System.out.println("Setting playback speed of audiobook: " + bookTitle + " to " + speed + "x");
        }
    }
}
