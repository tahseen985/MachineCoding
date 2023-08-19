package DesignLibraryManagmentSystem.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    String libraryName;
    List<Book> bookList;
    List<Rack> rackList;
    List<User> userList;
    Integer numberOfRack;
    Integer numberOfAvailableRacks;

    public Library(String libraryName, Integer numberOfRack) {
        this.libraryName = libraryName;
        this.numberOfRack = numberOfRack;
        this.numberOfAvailableRacks = numberOfRack;
        this.bookList = new ArrayList<>();
        this.rackList = new ArrayList<>();
        this.userList = new ArrayList<>();
        System.out.println("Created library with "  + numberOfRack + " racks");
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Rack> getRackList() {
        return rackList;
    }

    public void setRackList(List<Rack> rackList) {
        this.rackList = rackList;
    }

    public Integer getNumberOfAvailableRacks() {
        return numberOfAvailableRacks;
    }

    public void setNumberOfAvailableRacks(Integer numberOfAvailableRacks) {
        this.numberOfAvailableRacks = numberOfAvailableRacks;
    }

    public Integer getNumberOfRack() {
        return numberOfRack;
    }

    public void setNumberOfRack(Integer numberOfRack) {
        this.numberOfRack = numberOfRack;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void addBookList(Book book) {
        this.bookList.add(book);
    }

    public void addRackList(Rack rack) {
        this.rackList.add(rack);
    }

    public void addUserList(User user) {
        this.userList.add(user);
    }

    @Override
    public String toString() {
        return "Library{" +
                "libraryName='" + libraryName + '\'' +
                ", bookList=" + bookList +
                ", rackList=" + rackList +
                ", userList=" + userList +
                ", numberOfRack=" + numberOfRack +
                ", numberOfAvailableRacks=" + numberOfAvailableRacks +
                '}';
    }
}
