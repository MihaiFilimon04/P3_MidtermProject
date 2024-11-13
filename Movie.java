public class Movie {
    private String title;
    private String genre;
    private int releaseYear;
    private String movieID;
    private int availableCopies;


    public Movie(String title, String genre, int releaseYear, String movieID, int availableCopies) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.movieID = movieID;
        this.availableCopies = availableCopies;
    }


    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getReleaseYear() { return releaseYear; }
    public String getMovieID() { return movieID; }
    public int getAvailableCopies() { return availableCopies; }

    public void setAvailableCopies(int copies) { this.availableCopies = copies; }

    // decrease available copies when rented
    public void rentMovie() throws MovieNotAvailableException {
        if (availableCopies <= 0) {
            throw new MovieNotAvailableException("Movie not available for rent.");
        }
        availableCopies--;
    }
    public static class MovieNotAvailableException extends Exception {
        public MovieNotAvailableException(String message) { super(message); }
    }

    public class InvalidCustomerException extends Exception {
        public InvalidCustomerException(String message) { super(message); }
    }


    public void returnMovie() { availableCopies++; }
}
