import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String customerID;
    private List<Rental> rentalHistory;


    public Customer(String name, String customerID) {
        this.name = name;
        this.customerID = customerID;
        this.rentalHistory = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getCustomerID() { return customerID; }
    public List<Rental> getRentalHistory() { return rentalHistory; }

    //add a rental to the history
    public void addRentalToHistory(Rental rental) {
        rentalHistory.add(rental);
    }

    public boolean isValidCustomerID(String customerID) {
        return customerRentals.containsKey(customerID);
    }

    public boolean isValidMovieID(String movieID) {
        return movieID.stream().anyMatch(movie -> movieID.getMovieID().equals(movieID));
    }

}
