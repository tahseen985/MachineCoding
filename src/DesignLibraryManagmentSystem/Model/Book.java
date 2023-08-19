package DesignLibraryManagmentSystem.Model;

import java.util.ArrayList;
import java.util.List;

public class Book {
    String bookId;
    String title;
    List<String> author;
    List<String> publisher;
    List<BookItem> bookItemList;

    public Book(String bookId, String title, List<String> author, List<String> publisher) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.bookItemList = new ArrayList<>();
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public List<String> getPublisher() {
        return publisher;
    }

    public void setPublisher(List<String> publisher) {
        this.publisher = publisher;
    }

    public List<BookItem> getBookItemList() {
        return bookItemList;
    }

    public void setBookItemList(List<BookItem> bookItemList) {
        this.bookItemList = bookItemList;
    }

    public void addBookItem(BookItem bookItem) {
        this.bookItemList.add(bookItem);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", publisher=" + publisher +
                ", bookItemList=" + bookItemList +
                '}';
    }
}
