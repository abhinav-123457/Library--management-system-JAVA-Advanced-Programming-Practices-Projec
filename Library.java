package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Library {
    // List of available books in the library
    private ArrayList<String> books;
    // HashMap to store issued books and the user to whom they are issued
    private HashMap<String, String> issuedBooks;

    // Constructor to initialize books and issuedBooks
    public Library() {
        books = new ArrayList<>();
        issuedBooks = new HashMap<>();
        // Preloading some books into the library
        books.add("Dune by Frank Herbert");
        books.add("A Brief History of Time");
        books.add("Geronimo Stilton: The Mummy with No Name");
        books.add("Harry Potter and the Chamber of Secrets");
        books.add("Robin Sharma: Who Will Cry When You Die");
    }

    // Method to add a new book to the library
    public void addBook(String bookName) {
        books.add(bookName);
        System.out.println("'" + bookName + "' has been added to the library.\n");
    }

    // Method to display all available books
    public void displayBooks() {
        if (books.size() > 0) {
            System.out.println("Available books in the library:");
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
        } else {
            System.out.println("No books are currently available in the library.");
        }
        System.out.println();
    }

    // Method to issue a book to a user
    public void issueBook(String bookName, String user) {
        if (books.contains(bookName)) {
            books.remove(bookName);
            issuedBooks.put(bookName, user);
            System.out.println("'" + bookName + "' has been issued to " + user + ".\n");
        } else {
            System.out.println("Sorry, '" + bookName + "' is either not available or has already been issued.\n");
        }
    }

    // Method to return an issued book
    public void returnBook(String bookName) {
        if (issuedBooks.containsKey(bookName)) {
            String user = issuedBooks.remove(bookName);
            books.add(bookName);
            System.out.println("'" + bookName + "' has been returned by " + user + ".\n");
        } else {
            System.out.println("'" + bookName + "' was not issued by the library.\n");
        }
    }

    // Method to display all issued books
    public void issuedBooksList() {
        if (issuedBooks.size() > 0) {
            System.out.println("Issued books:");
            for (String book : issuedBooks.keySet()) {
                System.out.println("'" + book + "' issued to " + issuedBooks.get(book));
            }
        } else {
            System.out.println("No books have been issued.");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Library Management System ====");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Issued Books");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter the name of the book to add: ");
                    String bookName = scanner.nextLine();
                    library.addBook(bookName);
                    break;

                case "2":
                    library.displayBooks();
                    break;

                case "3":
                    System.out.print("Enter the name of the book to issue: ");
                    String issueBookName = scanner.nextLine();
                    System.out.print("Enter the name of the user: ");
                    String user = scanner.nextLine();
                    library.issueBook(issueBookName, user);
                    break;

                case "4":
                    System.out.print("Enter the name of the book to return: ");
                    String returnBookName = scanner.nextLine();
                    library.returnBook(returnBookName);
                    break;

                case "5":
                    library.issuedBooksList();
                    break;

                case "6":
                    System.out.println("Exiting Library Management System.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }
}
