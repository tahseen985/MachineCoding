package DesignLibraryManagmentSystem.Service;

import DesignLibraryManagmentSystem.Enum.RackStatus;
import DesignLibraryManagmentSystem.Model.*;
import DesignLibraryManagmentSystem.Repository.LibraryManagementRepo;

import java.util.*;

public class LibraryManagementService {

    Library library;
    LibraryManagementRepo libraryManagementRepo;
    public LibraryManagementService(Library library, LibraryManagementRepo libraryManagementRepo) {
        this.library = library;
        this.libraryManagementRepo = libraryManagementRepo;
    }

    public void addBookToLibrary(Book book) {
        if(library.getNumberOfAvailableRacks() < book.getBookItemList().size()) {
            System.out.println("Not Enough Space Available in Library");
            return;
        }
        libraryManagementRepo.getBookMap().put(book.getBookId(), book);
        library.addBookList(book);
        Integer index = 0;
        for (Rack rack : library.getRackList()) {
            if(RackStatus.FREE.toString().equalsIgnoreCase(rack.getRackStatus().toString())) {
                book.getBookItemList().get(index).setRackNumber(rack.getRackNumber());
                rack.setRackStatus(RackStatus.OCCUPIED);
                index++;
            }
            if(index == book.getBookItemList().size()) break;
        }
        library.setNumberOfAvailableRacks(library.getNumberOfAvailableRacks()-book.getBookItemList().size());
    }

    public void addBookToMap(Book book) {
        libraryManagementRepo.getBookMap().put(book.getBookId(), book);
    }

    public void addBookItemToBook(String bookId, BookItem bookItem) {
        libraryManagementRepo.getBookItemMap().put(bookItem.getBookItemId(), bookItem);
        libraryManagementRepo.getBookMap().get(bookId).addBookItem(bookItem);
    }

    public void addRackToLibrary(Rack rack) {
        library.addRackList(rack);
        libraryManagementRepo.getRackMap().put(rack.getRackNumber(), rack);
    }

    public void addUserToLibrary(User user) {
        library.addUserList(user);
        libraryManagementRepo.getUserMap().put(user.getUserId(), user);
    }

    public void removeBookItemFromLibrary(String bookItemId) {
        if(!libraryManagementRepo.getBookItemMap().containsKey(bookItemId)) {
            System.out.println("Invalid Book Copy ID");
            return;
        }
        BookItem bookItem = libraryManagementRepo.getBookItemMap().get(bookItemId);
        Rack rack = libraryManagementRepo.getRackMap().get(bookItem.getRackNumber());
        rack.setRackStatus(RackStatus.FREE);
        libraryManagementRepo.getBookMap().get(bookItem.getBookId()).getBookItemList().remove(bookItem);
        libraryManagementRepo.getBookItemMap().remove(bookItemId);
        System.out.println("Removed book copy: " + bookItem.getBookItemId() + " from rack: " + bookItem.getRackNumber());
        library.setNumberOfAvailableRacks(library.getNumberOfAvailableRacks()+1);
    }

    public void userBorrowBook(String bookItemId, String userId, Date dueDate) {
        User user = libraryManagementRepo.getUserMap().get(userId);
        if(user == null) {
            System.out.println("user is not the member");
            return;
        }
        if(user.getCount() >= user.getMaxCount()) {
            System.out.println("Over limit");
            return;
        }
        if(!libraryManagementRepo.getBookItemMap().containsKey(bookItemId)) {
            System.out.println("Invalid Book Copy ID");
            return;
        }
        BookItem item = libraryManagementRepo.getBookItemMap().get(bookItemId);
        libraryManagementRepo.getRackMap().get(item.getRackNumber()).setRackStatus(RackStatus.FREE);
        item.setDueDate(dueDate);
        libraryManagementRepo.getBookMap().get(item.getBookId()).getBookItemList().remove(item);
        libraryManagementRepo.getBookItemMap().remove(item.getBookItemId());
        user.addBookListItem(item);
        user.setCount(user.getCount()+1);
        libraryManagementRepo.getBookUserMap().put(item.getBookItemId(), user.getUserId());
        System.out.println("Borrowed Book Copy from rack: " + item.getRackNumber());
    }

    public void returnBorrowedBook(BookItem bookItem) {
        User user = libraryManagementRepo.getUserMap().get(libraryManagementRepo.getBookUserMap().get(bookItem.getBookItemId()));
        List<Rack> rackList = library.getRackList();

        Book book = libraryManagementRepo.getBookMap().get(bookItem.getBookId());
        Rack rack = null;
        for(Rack racks : rackList) {
            if(racks.getRackStatus().equals(RackStatus.FREE)) {
                rack = racks;
                break;
            }
        }
        bookItem.setRackNumber(rack.getRackNumber());
        rack.setRackStatus(RackStatus.OCCUPIED);
        book.getBookItemList().add(bookItem);
        libraryManagementRepo.getBookItemMap().put(bookItem.getBookItemId(), bookItem);
        user.getBookItemList().remove(bookItem);
        System.out.println("Returned book copy " + bookItem.getBookItemId() + " and added to rack " + rack.getRackNumber());
    }

    public void printBookItemIdBorrowedByUser(String userId) {
        User user = libraryManagementRepo.getUserMap().get(userId);
        List<BookItem> bookItemList = user.getBookItemList();
        for (BookItem bookItem : bookItemList) {
            System.out.println("Book Copy: " + bookItem.getBookItemId() + " " + bookItem.getDueDate());
        }
    }

    public void allAvailableRacks() {
        List<Rack> rackList = library.getRackList();
        List<Integer> racks = new ArrayList<>();
        for(Rack rack : rackList) {
            if(rack.getRackStatus().equals(RackStatus.FREE)) {
                racks.add(rack.getRackNumber());
            }
        }
        System.out.println(racks);
    }

    public List<Book> getListOfBookByBookId() {
        return null;
    }

    public List<Book> getListOfBookByTitle() {
        return null;
    }

    public List<Book> getListOfBookByAuthor() {
        return null;
    }

    public List<Book> getListOfBookByPublisher() {
        return null;
    }
}
