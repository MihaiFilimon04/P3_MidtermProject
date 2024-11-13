public interface Rentable {
    void rentMovie(String customerID, String movieID) throws Movie.MovieNotAvailableException;
    void returnMovie(String movieID);
}
