import java.util.*;

public class Inventory implements Storable {
    private List<Movie> movies;
    private Map<String, List<Rental>> customerRentals;
    public Inventory() {
        movies = new ArrayList<>();
        customerRentals = new HashMap<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }


    public Rental rentMovie(String customerID, String movieID, LocalDate rentalDate, LocalDate dueDate)
            throws Movie.MovieNotAvailableException {
        for (Movie movie : movies) {
            if (movie.getMovieID().equals(movieID)) {
                movie.rentMovie();
                Rental rental = new Rental(UUID.randomUUID().toString(), customerID, movieID, rentalDate, dueDate);

                // to add rental to customer's rental history
                customerRentals.computeIfAbsent(customerID, k -> new ArrayList<>()).add(rental);

                return rental;
            }
        }
        throw new Movie.MovieNotAvailableException("Movie with ID " + movieID + " not found.");
    }

    @Override
    public void saveData() { // to save in file

    }

    @Override
    public void loadData() { // load from file

    }

    public void returnMovie(String movieID) {
    }

    public boolean isValidMovieID(String movieID) {
    }

    public List<Rental> getCustomerRentalHistory(String customerID) {
    }

    public boolean isValidCustomerID(String customerID) {
    }
}
