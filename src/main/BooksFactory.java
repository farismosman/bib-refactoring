package main;

import java.util.ArrayList;
import java.util.List;

public class BooksFactory {

    private List<Integer> bookKeys = new ArrayList<Integer>();
    
    public List<Integer> booksId(){
        bookKeys.add(1);
        bookKeys.add(2);
        bookKeys.add(3);
        bookKeys.add(4);
        return bookKeys;
    }
    
    void books() {
        System.out.println(" 1. Sweet Valley High vol. 4 by John Travolta ");
        System.out.println(" 2. eXtreme Programming Explained by Kent Beck ");
        System.out.println(" 3. How to Win Friends and Influence People by Dale Carnagie ");
        System.out.println(" 4. How to Cheat at TWU Assignements by Anonymous ");
    }
}