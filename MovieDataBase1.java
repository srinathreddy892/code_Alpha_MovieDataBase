import java.util.ArrayList;
import java.util.Scanner;

class Movie {
    private String title;
    private String director;
    private int releaseYear;

    public Movie(String title, String director, int releaseYear) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
}

class MovieDatabase {
    private ArrayList<Movie> movies;

    public MovieDatabase() {
        movies = new ArrayList<>();
    }

    public void addMovie(String title, String director, int releaseYear) {
        Movie movie = new Movie(title, director, releaseYear);
        movies.add(movie);
    }

    public ArrayList<Movie> search(String keyword) {
        ArrayList<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(movie);
            }
        }
        return result;
    }

    public void displayAllMovies() {
        for (Movie movie : movies) {
            System.out.println("Title: " + movie.getTitle());
            System.out.println("Director: " + movie.getDirector());
            System.out.println("Release Year: " + movie.getReleaseYear());
            System.out.println();
        }
    }
}

public class MovieDataBase1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieDatabase database = new MovieDatabase();

        // Add some initial movies
        database.addMovie("Inception", "Christopher Nolan", 2010);
        database.addMovie("The Shawshank Redemption", "Frank Darabont", 1994);

        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add a movie");
            System.out.println("2. Search for a movie");
            System.out.println("3. Display all movies");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter movie title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter movie director: ");
                    String director = scanner.nextLine();
                    System.out.print("Enter release year: ");
                    int releaseYear = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    database.addMovie(title, director, releaseYear);
                    System.out.println("Movie added successfully!");
                    break;
                case 2:
                    System.out.print("Enter keyword to search: ");
                    String keyword = scanner.nextLine();
                    ArrayList<Movie> searchResult = database.search(keyword);
                    if (searchResult.isEmpty()) {
                        System.out.println("No matching movies found.");
                    } else {
                        System.out.println("Matching movies:");
                        for (Movie movie : searchResult) {
                            System.out.println("Title: " + movie.getTitle());
                            System.out.println("Director: " + movie.getDirector());
                            System.out.println("Release Year: " + movie.getReleaseYear());
                            System.out.println();
                        }
                    }
                    break;
                case 3:
                    System.out.println("All movies:");
                    database.displayAllMovies();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

        scanner.close();
    }
}
