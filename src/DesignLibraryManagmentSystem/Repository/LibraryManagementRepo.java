package DesignLibraryManagmentSystem.Repository;

import DesignLibraryManagmentSystem.Model.Book;
import DesignLibraryManagmentSystem.Model.BookItem;
import DesignLibraryManagmentSystem.Model.Rack;
import DesignLibraryManagmentSystem.Model.User;

import java.util.HashMap;
import java.util.Map;

public class LibraryManagementRepo {
    Map<String, BookItem> bookItemMap = new HashMap<>();
    Map<String, User> userMap = new HashMap<>();
    Map<Integer, Rack> rackMap = new HashMap<>();
    Map<String, Book> bookMap = new HashMap<>();
    Map<String, String> bookUserMap = new HashMap<>();

    public Map<String, BookItem> getBookItemMap() {
        return bookItemMap;
    }

    public void setBookItemMap(Map<String, BookItem> bookItemMap) {
        this.bookItemMap = bookItemMap;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Map<Integer, Rack> getRackMap() {
        return rackMap;
    }

    public void setRackMap(Map<Integer, Rack> rackMap) {
        this.rackMap = rackMap;
    }

    public Map<String, Book> getBookMap() {
        return bookMap;
    }

    public void setBookMap(Map<String, Book> bookMap) {
        this.bookMap = bookMap;
    }

    public Map<String, String> getBookUserMap() {
        return bookUserMap;
    }

    public void setBookUserMap(Map<String, String> bookUserMap) {
        this.bookUserMap = bookUserMap;
    }
}
