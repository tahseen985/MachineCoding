package DesignTrello.Model;

public class User {
    String userId;
    String userName;
    String email;
    private static int userIdCounter = 1;

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
        this.userId = userName + '0' + userIdCounter;
        userIdCounter++;
        System.out.println("User created with name : " + userName);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
