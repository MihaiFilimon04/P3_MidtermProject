import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MovieRentalApp
{

    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        // load and show config files
        Config.loadConfig();
        inventory.loadData(); // scrie filme

        boolean running = true;


        while (running) {
            System.out.println("Welcome to the Movie Rental System");
            System.out.println("1. Add Movie to Inventory");
            System.out.println("2. Rent a Movie");
            System.out.println("3. Return a Movie");
            System.out.println("4. View Customer Rental History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addMovieToInventory(inventory, scanner);
                    break;
                case 2:
                    rentMovie(inventory, scanner);
                    break;
                case 3:
                    returnMovie(inventory, scanner);
                    break;
                case 4:
                    viewCustomerHistory(inventory, scanner);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        // save data
        inventory.saveData();
        System.out.println("Thank you for using the Movie Rental System! Muie Calinescu Razvan");
        scanner.close();
    }

    // metode pt actiuni
    private static void addMovieToInventory(Inventory inventory, Scanner scanner) {
        System.out.print("Enter movie title: ");
        String title = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter release year: ");
        int releaseYear = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter available copies: ");
        int copies = Integer.parseInt(scanner.nextLine());
        String movieID = generateUniqueID();

        Movie movie = new Movie(title, genre, releaseYear, movieID, copies);
        inventory.addMovie(movie);
        System.out.println("Movie added to inventory.");
    }

    private static String generateUniqueID() {
        return "ID:";
    }

    private static void rentMovie(Inventory inventory, Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        String customerID = scanner.nextLine();
        System.out.print("Enter Movie ID: ");
        String movieID = scanner.nextLine();

        // validare id-uri
        if (!inventory.isValidCustomerID(customerID)) {
            System.out.println("Invalid Customer ID.");
            return;
        }
        if (!inventory.isValidMovieID(movieID)) {
            System.out.println("Invalid Movie ID.");
            return;
        }

        LocalDate rentalDate = LocalDate.now();
        LocalDate dueDate = rentalDate.plusDays(Config.getRentalDuration());

        try {
            Rental LocalDate = inventory.rentMovie(customerID, movieID, rentalDate, dueDate);
            System.out.println("Movie rented successfully. Due date: " + dueDate);
        } catch (Movie.MovieNotAvailableException | Movie.InvalidCustomerException e) {
            System.out.println("Rental failed: " + e.getMessage());
        }
    }

    private static void returnMovie(Inventory inventory, Scanner scanner) {
        System.out.print("Enter Movie ID to return: ");
        String movieID = scanner.nextLine();

        if (!inventory.isValidMovieID(movieID)) {
            System.out.println("Invalid Movie ID.");
            return;
        }

        inventory.returnMovie(movieID);
        System.out.println("Movie returned successfully.");
    }

    private static void viewCustomerHistory(Inventory inventory, Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        String customerID = scanner.nextLine();

        if (!inventory.isValidCustomerID(customerID)) {
            System.out.println("Customer ID not found.");
            return;
        }

        List<Rental> rentals = inventory.getCustomerRentalHistory(customerID);
        System.out.println("Rental History for Customer " + customerID + ":");
        for (Rental rental : rentals) {
            System.out.println("Movie ID: " + rental.getMovieID() + ", Rented on: " +
                    rental.getRentalDate() + ", Due on: " + rental.getDueDate());
        }
    }
}

    // id unic
/*    private static String generateUniqueID() {
        return UUID.randomUUID().toString();
    }
}*/
