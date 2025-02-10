package com.celcom.Saturday_Assignment_8th_Feb_2025;

import java.util.HashMap;
import java.util.Scanner;

class Book {
	String bookTitle;
	String authorName;
	int isbn;

	Book(String bookTitle, String authorName, int isbn) {
		this.bookTitle = bookTitle;
		this.authorName = authorName;
		this.isbn = isbn;
	}
}

class BookManager {
	Scanner inputScanner = new Scanner(System.in);
	HashMap<Integer, Book> bookStore = new HashMap<Integer, Book>();

	void add() {
		Book book = new Book(inputScanner.next(), inputScanner.next(), inputScanner.nextInt());
		bookStore.put(book.isbn, book);
		System.out.println("Book added\n");
	}

	void remove(int isbn) {
		if (bookStore.containsKey(isbn)) {
			bookStore.remove(isbn);
			System.out.println("Book Removed\n");
		} else
			System.out.println("Not found the book\n");
	}

	void display() {
		int i = 0;
		for (Book val : bookStore.values()) {
			System.out.println("-----------------");
			System.out.println("Author name: "+ val.authorName);
			System.out.println("Book title: "+ val.bookTitle);
			System.out.println("Isbn : " + val.isbn);
			System.out.println("-----------------");
			i=1;
		}
		if(i == 0) {
			System.out.println("Empty library\n");
		}
	}

}

public class Program5 {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		int choice;
		System.out.println("Book Manager\n");

		Scanner sc = new Scanner(System.in);

		BookManager bookManager = new BookManager();

		while (true) {
			System.out.println("Enter the choice\n1. Add\n2. Remove\n3. Display\n4. Exit\n");
			System.out.print("---> ");
			choice = inputScanner.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter the Book title, Author name, ISBN: ");
				bookManager.add();
				break;
			case 2:
				System.out.print("Enter the ISBN number to remove book: ");
				int isbn = sc.nextInt();

				bookManager.remove(isbn);
				break;
			case 3:
				bookManager.display();
				break;

			default:
				if (choice == 4) {
					System.out.println("Thank you");
					System.exit(0);
				} else {
					System.out.println("Ivalid choice\n");
					break;
				}
			}
		}

	}

}
