package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Program {
    private boolean loggedIn = false;
    private String savedLibraryNumber = "";

    InputStreamReader inputStream = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(inputStream);
    private final BooksFactory booksFactory = new BooksFactory();
    private final MoviesFactory moviesFactory = new MoviesFactory();
    private Menu menu = new Menu();

    public void main(String[] args) {
        while (true) {
            welcomeMessage();
            menu.menuOption();

            int userInput = getInput();
            if (userInput == 1) {
                booksFactory.books();
            } else if (userInput == 2) {
                processBook();
            } else if (userInput == 3) {
                checkLibNumber();
            } else if (userInput == 4) {
                moviesFactory.movies();
            } else if (userInput == 5) {
                clearLogin();
                loginUser();

            } else if (userInput == 9) {
                System.out.println("Quitting...");
                break;
            } else {
                System.out.println("\n");
                System.out.println("Enter a valid integer!!");
            }
        }
    }

    private void loginUser() {
        System.out.println("Enter your library number");
        try {
            String libraryNumber = reader.readLine();
            if (validLibraryNumber(libraryNumber)) {
                System.out.println("Enter your Password: ");
                try {
                    String password = reader.readLine();
                    if (validPassword(password)) {
                        loggedIn = true;
                        savedLibraryNumber = libraryNumber;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid password");
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid username");
        }
    }

    private int getInput() {
        int userInput = 0;
        try {
            String value = reader.readLine();
            userInput = Integer.parseInt(value);
        } catch (Exception e) {
            // Do you know what numbers are!!!
            System.out.println("Enter a valid integer!!");
        }
        return userInput;
    }

    private void processBook() {
        int bookNumber = chooseABook(reader);
        List<Integer> booksKeys = new ArrayList<Integer>();
        booksKeys.add(1);
        booksKeys.add(2);
        booksKeys.add(3);
        booksKeys.add(4);
        if (booksKeys.contains(bookNumber)){
            System.out.println("\n Thank You! Enjoy the book.");
        } else {
            System.out.println("\nSorry we don't have that book yet.");
        }
    }

    private int chooseABook(BufferedReader reader) {
        System.out.println(" Please enter the number of the book you wish to checkout: ");
        int bookNumber = 0;
        try {
            bookNumber = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            // Do you know what numbers are!!!
            System.out.println("Enter a valid integer!!");

        }
        return bookNumber;
    }

    private void checkLibNumber() {
        if (loggedIn()) {
            System.out.println("\nYour library number is " + savedLibraryNumber);
        } else {

            System.out.println("\nPlease talk to Librarian. Thank you.");
        }
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

}

