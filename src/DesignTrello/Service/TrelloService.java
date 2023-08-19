package DesignTrello.Service;

import DesignTrello.Enum.Privacy;
import DesignTrello.Model.*;
import DesignTrello.Repository.TrelloRepo;

public class TrelloService {
    App app;
    TrelloRepo trelloRepo;

    public TrelloService(App app, TrelloRepo trelloRepo) {
        this.app = app;
        this.trelloRepo = trelloRepo;
    }
    public void show(App app) {
        System.out.println(app.toString());
    }

    public void boardShow(String boardId, App app) {
        Board board = trelloRepo.getBoardMap().get(boardId);
        System.out.println(board.toString());
    }

    public void projectShow(String listId, App app) {
        Project project = trelloRepo.getProjectMap().get(listId);
        System.out.println(project.toString());
    }

    public void cardShow(String cardId, App app) {
        Card card = trelloRepo.getCardMap().get(cardId);
        System.out.println(card.toString());
    }

    public void putBoardInMap(Board board) {
        trelloRepo.putBoardInMap(board);
    }

    public void updateBoardName(String boardId, App app, String name) {
        Board board = trelloRepo.getBoardMap().get(boardId);
        board.setName(name);
        System.out.println("Update Board with Id : " + boardId + " with new name : " + name);
    }

    public void updateBoardPrivacy(String boardId, App app, String privacy) {
        Board board = trelloRepo.getBoardMap().get(boardId);
        if(Privacy.PRIVATE.name().equalsIgnoreCase(privacy)) {
            board.setPrivacy(Privacy.PRIVATE);
        } else {
            board.setPrivacy(Privacy.PUBLIC);
        }
        System.out.println("Update Board with Id : " + boardId + " with new privacy : " + privacy);
    }

    public void addUserToBoard(String boardId, User user, App app) {
        Board board = trelloRepo.getBoardMap().get(boardId);
        board.addUser(user);
        trelloRepo.putUserInMap(user);
        System.out.println("Added User with userId : " + user.getUserId() + " in Board with Id : " + boardId);
    }

    public void addProjectToBoard(String boardId, Project project, App app) {
        Board board = trelloRepo.getBoardMap().get(boardId);
        board.addProject(project);
        trelloRepo.putProjectInMap(project);
        System.out.println("Added Project with projectId : " + project.getId() + " in Board with Id : " + boardId);
    }

    public void addCardToProject(String projectId, Card card, App app) {
        Project project = trelloRepo.getProjectMap().get(projectId);
        project.getCardList().add(card);
        trelloRepo.putCardInMap(card);
        System.out.println("Added Card with cardId : " + card.getId() + " in project with Id : " + projectId);
    }

    public void removeUserToBoard(String boardId, User user, App app) {
        Board board = trelloRepo.getBoardMap().get(boardId);
        board.getMemberList().remove(user);
        trelloRepo.getUserMap().remove(user.getUserId());
        System.out.println("Remove User with userId : " + user.getUserId() + " in Board with Id : " + boardId);
    }

    public void deleteBoard(String boardId, App app) {
        app.getBoardList().remove(trelloRepo.getBoardMap().get(boardId));
        System.out.println("Remove Board with boardIf : " + boardId);
    }

    public void updateCardName(String cardId, String name, App app) {
        Card card = trelloRepo.getCardMap().get(cardId);
        card.setName(name);
        System.out.println("Updated Card with cardId : " + card.getId() + " with new name : " + name);
    }

    public void updateCardDescription(String cardId, String description, App app) {
        Card card = trelloRepo.getCardMap().get(cardId);
        card.setDescription(description);
        System.out.println("Updated Card with cardId : " + card.getId() + " with new description : " + description);
    }

    public void updateProjectName(String projectId, String name, App app) {
        Project project = trelloRepo.getProjectMap().get(projectId);
        project.setName(name);
        System.out.println("Updated Project with projectID : " + project.getId() + " with new name : " + name);
    }

    public void cardAssign(String cardId, String userId, App app) {
        Card card = trelloRepo.getCardMap().get(cardId);
        User user = trelloRepo.getUserMap().get(userId);
        card.setUser(user);
        trelloRepo.putUserCardInMap(userId, cardId);
        System.out.println("Assign Card with cardId : " + card.getId() + " to User with UserId : " + userId);
    }

    public void cardMove(String cardId, String userId, App app) {

    }

    public void cardUnAssign(String cardId, App app) {
        Card card = trelloRepo.getCardMap().get(cardId);
        trelloRepo.getUserCardMapping().remove(cardId);
        card.setUser(null);
        System.out.println("Card unassigned");
    }
}
