package DesignLibraryManagmentSystem.Model;

import java.util.Date;

public class BookItem {
    String bookItemId;
    Integer rackNumber;
    String bookId;
    Date dueDate;

    public BookItem(String bookItemId, String bookId) {
        this.bookItemId = bookItemId;
        this.bookId = bookId;
    }

    public String getBookItemId() {
        return bookItemId;
    }

    public void setBookItemId(String bookItemId) {
        this.bookItemId = bookItemId;
    }

    public Integer getRackNumber() {
        return rackNumber;
    }

    public void setRackNumber(Integer rackNumber) {
        this.rackNumber = rackNumber;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "BookItem{" +
                "bookItemId='" + bookItemId + '\'' +
                ", rackNumber=" + rackNumber +
                ", bookId='" + bookId + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}
