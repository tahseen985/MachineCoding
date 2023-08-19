package DesignLibraryManagmentSystem.Controller;

import DesignLibraryManagmentSystem.Model.*;
import DesignLibraryManagmentSystem.Repository.LibraryManagementRepo;
import DesignLibraryManagmentSystem.Service.LibraryManagementService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controller {
    public static void main(String[] args) {
        String libraryName = "Khuda Baksh Library";
        Integer numberOfRack = 10;
        Integer maxNUmberOfCount = 5;

        //creating library
        Library library = new Library(libraryName, numberOfRack);
        LibraryManagementRepo libraryManagementRepo = new LibraryManagementRepo();

        LibraryManagementService libraryManagementService = new LibraryManagementService(library, libraryManagementRepo);

        //creating and adding rack
        for(int i=0; i<numberOfRack; i++) {
            Rack rack = new Rack(i+1, "free");
            libraryManagementService.addRackToLibrary(rack);
        }

        libraryManagementService.allAvailableRacks();

        // creating and adding user
        User user1 = new User("tahseen.akram", maxNUmberOfCount);
        libraryManagementService.addUserToLibrary(user1);
        User user2 = new User("ashish.upadhyay", maxNUmberOfCount);
        libraryManagementService.addUserToLibrary(user2);
        User user3 = new User("faiz.akram", maxNUmberOfCount);
        libraryManagementService.addUserToLibrary(user3);
        User user4 = new User("shrey.rai", maxNUmberOfCount);
        libraryManagementService.addUserToLibrary(user4);

        // creating book, book item and adding it to library
        String bookId1 = "12345";
        String title = "testing";
        List<String> authors = new ArrayList<>();
        authors.add("tester");
        List<String> publishers = new ArrayList<>();
        publishers.add("developer");
        Book book = new Book(bookId1, title, authors, publishers);
        libraryManagementService.addBookToMap(book);
        BookItem bookItem1 = new BookItem("GOT", book.getBookId());
        BookItem bookItem2 = new BookItem("LOR", book.getBookId());
        BookItem bookItem3 = new BookItem("tester", book.getBookId());
        BookItem bookItem4 = new BookItem("savita bhabhi", book.getBookId());
        libraryManagementService.addBookItemToBook(book.getBookId(), bookItem1);
        libraryManagementService.addBookItemToBook(book.getBookId(), bookItem2);
        libraryManagementService.addBookItemToBook(book.getBookId(), bookItem3);
        libraryManagementService.addBookItemToBook(book.getBookId(), bookItem4);
        libraryManagementService.addBookToLibrary(book);

        String bookId2 = "6789";
        String title2 = "testing2";
        List<String> authors2 = new ArrayList<>();
        authors2.add("tester2");
        List<String> publishers2 = new ArrayList<>();
        publishers2.add("developer2");
        Book book2 = new Book(bookId2, title2, authors2, publishers2);
        libraryManagementService.addBookToMap(book2);
        BookItem bookItem5 = new BookItem("test1", book2.getBookId());
        BookItem bookItem6 = new BookItem("test2", book2.getBookId());
        BookItem bookItem7 = new BookItem("test3", book2.getBookId());
        BookItem bookItem8 = new BookItem("test4", book2.getBookId());
        libraryManagementService.addBookItemToBook(book2.getBookId(), bookItem5);
        libraryManagementService.addBookItemToBook(book2.getBookId(), bookItem6);
        libraryManagementService.addBookItemToBook(book2.getBookId(), bookItem7);
        libraryManagementService.addBookItemToBook(book2.getBookId(), bookItem8);
        libraryManagementService.addBookToLibrary(book2);

        System.out.println(library.toString());

        libraryManagementService.allAvailableRacks();

        // user borrowed book
        libraryManagementService.userBorrowBook(bookItem1.getBookItemId(), user1.getUserId(), new Date());
        libraryManagementService.userBorrowBook(bookItem2.getBookItemId(), user2.getUserId(), new Date());
        libraryManagementService.userBorrowBook(bookItem3.getBookItemId(), user3.getUserId(), new Date());
        libraryManagementService.userBorrowBook(bookItem4.getBookItemId(), user1.getUserId(), new Date());

        System.out.println(library.toString());

        libraryManagementService.printBookItemIdBorrowedByUser(user1.getUserId());
        libraryManagementService.printBookItemIdBorrowedByUser(user2.getUserId());
        libraryManagementService.allAvailableRacks();
        libraryManagementService.returnBorrowedBook(bookItem1);
        System.out.println(library.toString());
        libraryManagementService.allAvailableRacks();
        libraryManagementService.removeBookItemFromLibrary(bookItem1.getBookItemId());
        libraryManagementService.allAvailableRacks();

        System.out.println(library.toString());
    }
}
