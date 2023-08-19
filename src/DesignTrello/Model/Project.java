package DesignTrello.Model;

import java.util.ArrayList;
import java.util.List;

public class Project {
    String id;
    String name;
    List<Card> cardList;

    private static int projectIdCounter = 1;

    public Project(String name) {
        this.name = name;
        this.id = name + '0' + projectIdCounter;
        this.cardList = new ArrayList<>();
        projectIdCounter++;
        System.out.println("Project created with name : " + name);
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

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public void addCard(Card card) {
        this.cardList.add(card);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cardList=" + cardList +
                '}';
    }
}
