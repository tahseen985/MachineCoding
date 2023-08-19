package DesignTrello.Model;

public class Card {
    String id;
    String name;
    User user;
    String description;
    private static int cardIdCounter = 1;

    public Card(String name) {
        this.name = name;
        this.id = name + '0' + cardIdCounter;
        cardIdCounter++;
        System.out.println("Card created with name : " + name);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", description='" + description + '\'' +
                '}';
    }
}
