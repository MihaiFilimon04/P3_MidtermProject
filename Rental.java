import java.time.LocalDate;

public class Rental {
    private String rentalID;
    private String customerID;
    private String movieID;
    private LocalDate rentalDate;
    private LocalDate dueDate;

    public Rental(String rentalID, String customerID, String movieID, LocalDate rentalDate, LocalDate dueDate) {
        this.rentalID = rentalID;
        this.customerID = customerID;
        this.movieID = movieID;
        this.rentalDate = rentalDate;
        this.dueDate = dueDate;
    }

    public String getRentalID() { return rentalID; }
    public String getCustomerID() { return customerID; }
    public String getMovieID() { return movieID; }
    public LocalDate getRentalDate() { return rentalDate; }
    public LocalDate getDueDate() { return dueDate; }
}
