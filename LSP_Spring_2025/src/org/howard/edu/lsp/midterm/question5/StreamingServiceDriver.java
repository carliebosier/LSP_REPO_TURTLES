package org.howard.edu.lsp.midterm.question5;

public class StreamingServiceDriver {
    public static void main(String[] args) {
        // Create an instance of the StreamingService (outer class)
        StreamingService streamingService = new StreamingService();

        // Create instances of different media types using the outer class instance
        StreamingService.Music music = streamingService.new Music("Still a Friend - Incognito");
        StreamingService.Movie movie = streamingService.new Movie("Avengers End Game");
        StreamingService.Audiobook audiobook = streamingService.new Audiobook("A Promised Land – Barack Obama");

        // Test the common behaviors for all media types (play, pause, stop)
        System.out.println("Testing common behaviors for all media types:\n");

        // Test Music
        System.out.println("Testing Music:");
        music.play();
        music.pause();
        music.stop();
        System.out.println();

        // Test Movie
        System.out.println("Testing Movie:");
        movie.play();
        movie.pause();
        movie.stop();
        System.out.println();

        // Test Audiobook
        System.out.println("Testing Audiobook:");
        audiobook.play();
        audiobook.pause();
        audiobook.stop();
        System.out.println();

// Test unique behaviors for each media type

        // Test Movie-specific behavior (rewind)
        movie.rewind(30); //displays in seconds 
        System.out.println();

        // Test Audiobook-specific behavior (setPlaybackSpeed)
        audiobook.setPlaybackSpeed(1.5);
        System.out.println();

        // Test Music-specific behavior (addToPlaylist)
        music.addToPlaylist("Favorites");
        System.out.println();
    }
}
