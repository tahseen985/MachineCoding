package DesignTrello.Repository;

import DesignTrello.Model.Board;
import DesignTrello.Model.Card;
import DesignTrello.Model.Project;
import DesignTrello.Model.User;

import java.util.HashMap;
import java.util.Map;

public class TrelloRepo {
    Map<String, Board> boardMap;
    Map<String, Project> projectMap;
    Map<String, Card> cardMap;
    Map<String, User> userMap;
    Map<String, String> userCardMapping;

    public TrelloRepo() {
        this.boardMap = new HashMap<String, Board>();
        this.projectMap = new HashMap<String, Project>();
        this.cardMap = new HashMap<String, Card>();
        this.userMap = new HashMap<String, User>();
        this.userCardMapping = new HashMap<String, String>();
    }

    public void putBoardInMap(Board board) {
        this.boardMap.put(board.getId(), board);
    }

    public void putUserInMap(User user) {
        this.userMap.put(user.getUserId(), user);
    }

    public void putProjectInMap(Project project) {
        this.projectMap.put(project.getId(), project);
    }

    public void putCardInMap(Card card) {
        this.cardMap.put(card.getId(), card);
    }

    public void putUserCardInMap(String cardId, String userId) {
        this.userCardMapping.put(userId, cardId);
    }

    public Map<String, Board> getBoardMap() {
        return boardMap;
    }

    public void setBoardMap(Map<String, Board> boardMap) {
        this.boardMap = boardMap;
    }

    public Map<String, Project> getProjectMap() {
        return projectMap;
    }

    public void setProjectMap(Map<String, Project> projectMap) {
        this.projectMap = projectMap;
    }

    public Map<String, Card> getCardMap() {
        return cardMap;
    }

    public void setCardMap(Map<String, Card> cardMap) {
        this.cardMap = cardMap;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Map<String, String> getUserCardMapping() {
        return userCardMapping;
    }

    public void setUserCardMapping(Map<String, String> userCardMapping) {
        this.userCardMapping = userCardMapping;
    }
}
