package DesignLibraryManagmentSystem.Model;

import java.util.ArrayList;
import java.util.List;

public class User {
    String userId;
    String userName;
    List<BookItem> bookItemList;
    Integer count;
    Integer maxCount;
    private static int userIdCounter = 1;
    public User(String userName, Integer maxCount) {
        this.userId = userName + '0' + userIdCounter;
        this.userName = userName;
        this.bookItemList = new ArrayList<>();
        this.count = 0;
        this.maxCount = maxCount;
        userIdCounter++;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<BookItem> getBookItemList() {
        return bookItemList;
    }

    public void setBookItemList(List<BookItem> bookItemList) {
        this.bookItemList = bookItemList;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(Integer maxCount) {
        this.maxCount = maxCount;
    }

    public void addBookListItem(BookItem bookItem) {
        this.bookItemList.add(bookItem);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", bookItemList=" + bookItemList +
                ", count=" + count +
                ", maxCount=" + maxCount +
                '}';
    }
}
