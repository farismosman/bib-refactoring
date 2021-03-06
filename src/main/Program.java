package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Program {
    private final int VIEW_ALL_BOOKS = 1;
    private final int RESERVE_A_BOOK = 2;
    private final int CHECK_LIB_NUMBER = 3;
    private final int VIEW_ALL_MOVIES = 4;
    private final int LOGIN = 5;
    private final int QUIT = 9;
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

            int userInput = Integer.parseInt(getInput());
            if (userInput == VIEW_ALL_BOOKS) {
                booksFactory.books();
            } else if (userInput == RESERVE_A_BOOK) {
                reserveABook();
            } else if (userInput == CHECK_LIB_NUMBER) {
                checkLibNumber();
            } else if (userInput == VIEW_ALL_MOVIES) {
                moviesFactory.movies();
            } else if (userInput == LOGIN) {
                clearLogin();
                loginUser();
            } else if (userInput == QUIT) {
                System.out.println("Quitting...");
                break;
            } else {
                System.out.println("\nEnter a valid integer!!");
            }
        }
    }

    private void loginUser() {
        try {
            System.out.println("Enter your library number");
            String libraryNumber = getInput();
            System.out.println("Enter your Password: ");
            String password = getInput();
            if (validLibraryNumber(libraryNumber) && validPassword(password)) {
                loggedIn = true;
                savedLibraryNumber = libraryNumber;
            }
        } catch (Exception e) {
            System.out.println("Invalid username or password");
        }
    }

    private String getInput() {
        String userInput = "";
        try {
            userInput = reader.readLine();
        } catch (Exception e) {
            // Do you know what numbers are!!!
            System.out.println("Enter a valid input!!");
        }
        return userInput;
    }

    private void reserveABook() {
        int bookNumber = chooseABook();
        if (booksFactory.booksId().contains(bookNumber)){
            System.out.println("\n Thank You! Enjoy the book.");
        } else {
            System.out.println("\nSorry we don't have that book yet.");
        }
    }

    private int chooseABook() {
        System.out.println(" Please enter the number of the book you wish to checkout: ");
        int bookNumber = 0;
        try {
            bookNumber = Integer.parseInt(getInput());
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

