package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Program {
    private boolean loggedIn = false;
    private String savedLibraryNumber = "";

    public void main(String[] args) {
        while (true) {
            welcomeMessage();
            menuOption();

            InputStreamReader inputStream = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(inputStream);
            int i1 = 0;
            try {
                String value = reader.readLine();
                i1 = Integer.parseInt(value);
            } catch (Exception e) {
                // Do you know what numbers are!!!
                System.out.println("Enter a valid integer!!");
            }

            if (i1 == 1) {
                allBooks();
            } else if (i1 == 2) {
                int i2 = chooseABook(reader);
                switch (i2) {
                    case 1:
                        System.out.println("\n");
                        System.out.println(" Thank You! Enjoy the book.");
                        break;
                    case 2:
                        System.out.println("\n");
                        System.out.println(" Thank You! Enjoy the book.");
                        break;
                    case 3:
                        System.out.println("\n");
                        System.out.println(" Thank You! Enjoy the book.");
                        break;
                    case 4:
                        System.out.println("\n");
                        System.out.println(" Thank You! Enjoy the book.");
                        break;
                    default:
                        System.out.println("\n");
                        System.out.println("Sorry we don't have that book yet.");
                }
            } else if (i1 == 3) {
                checkLibNumber();
            } else if (i1 == 4) {
                System.out.println(createMovie("Rocky", "John G. Avildsen", "10"));
                System.out.println(createMovie("Rocky II", "John G. Avildsen", "9"));
                System.out.println(createMovie("Rocky III", "John G. Avildsen", "8"));
                System.out.println(createMovie("Rocky IV", "John G. Avildsen", "7"));
                System.out.println(createMovie("Rocky V", "John G. Avildsen", "8"));
                System.out.println(createMovie("Drainage", "Francisco Trindade", "N/A"));
                System.out.println(createMovie("The Shawshank Redemption", "Frank Darabont", "10"));
                System.out.println(createMovie("The Godfather", "Francis Ford Coppola", "7"));
                System.out.println(createMovie("Inception", "Frank Darabont", "10"));
                System.out.println(createMovie("Pulp Fiction", "Quentin Tarantino", "6"));
            } else if (i1 == 5) {
                clearLogin();
                System.out.println("Enter your library number");
                try {
                    String libraryNumber = reader.readLine();
                    if (validLibraryNumber(libraryNumber)) {
                        try {
                            System.out.println("Enter your Password: ");
                            String password = reader.readLine();
                            if (validPassword(password)) {
                                loggedIn = true;
                                savedLibraryNumber = libraryNumber;
                            }
                        } catch (Exception e) {

                        }
                    }
                } catch (Exception e) {

                }

            } else if (i1 == 9) {
                System.out.println("Quitting...");
                break;
            } else {
                System.out.println("\n");
                System.out.println("Enter a valid integer!!");
            }
        }
    }

    private int chooseABook(BufferedReader reader) {
        System.out.println(" Please enter the number of the book you wish to checkout: ");
        int i2 = 0;
        try {
            i2 = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            // Do you know what numbers are!!!
            System.out.println("Enter a valid integer!!");

        }
        return i2;
    }

    private void checkLibNumber() {
        if (loggedIn()) {
            System.out.println("\n");
            System.out.println("Your library number is " + savedLibraryNumber);
        } else {

            System.out.println("\n");
            System.out.println("Please talk to Librarian. Thank you.");
        }
    }

    private void allBooks() {
        System.out.println(" 1. Sweet Valley High vol. 4 by John Travolta ");
        System.out.println(" 2. eXtreme Programming Explained by Kent Beck ");
        System.out.println(" 3. How to Win Friends and Influence People by Dale Carnagie ");
        System.out.println(" 4. How to Cheat at TWU Assignements by Anonymous ");
    }

    private void menuOption() {
        System.out.println("*                Menu                                    *");
        System.out.println("*         =====================                          *");
        System.out.println("*         1. List Book Catalog                           *");
        System.out.println("*         2. Check out Book                              *");
        System.out.println("*         3. Check Library Number                        *");
        System.out.println("*         4. Movie Listing                               *");
        System.out.println("*         5. Login                                       *");
        System.out.println("*         9. Exit                                        *");
        System.out.println("**********************************************************");
        System.out.println("Your Selection: ");
    }

    private void welcomeMessage() {
        System.out.println("**********************************************************");
        System.out.println("* Welcome to The Bangalore Public Library System - Biblioteca *");
        System.out.println("**********************************************************");
    }

    private boolean validPassword(String password) {
        return "bhaisahab".equals(password);
    }

    private boolean validLibraryNumber(String libraryNumber) {
        return libraryNumber.matches("\\d\\d\\d-\\d\\d\\d\\d");
    }

    private boolean loggedIn() {
        return loggedIn;
    }


    private void clearLogin() {
        loggedIn = false;
        savedLibraryNumber = "";
    }

    private String createMovie(String movieTitle, String movieDirector, String movieRanking) {
        return movieTitle + " - Director: " + movieDirector + " Rating: " + movieRanking;
    }
}

