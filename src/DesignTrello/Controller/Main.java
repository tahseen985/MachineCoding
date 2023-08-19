package DesignTrello.Controller;

import DesignTrello.Model.*;
import DesignTrello.Repository.TrelloRepo;
import DesignTrello.Service.TrelloService;

public class Main {
    public static void main(String[] args) {
        App app = new App("Trello");
        TrelloRepo trelloRepo = new TrelloRepo();
        TrelloService trelloService = new TrelloService(app, trelloRepo);
        User user1 = new User("Tahseen", "tahseenakram985@gmail.com");
        User user2 = new User("Ashish", "ashishupadhyay123@gmail.com");
        User user3 = new User("Faiz", "faizakram453@gmail.com");

        Board board1 = new Board("work@tech");
        app.addBoard(board1);
        trelloService.putBoardInMap(board1);
        Board board2 = new Board("workat");
        app.addBoard(board2);
        trelloService.putBoardInMap(board2);
        trelloService.boardShow(board1.getId(), app);
        trelloService.boardShow(board2.getId(), app);
        trelloService.updateBoardPrivacy(board1.getId(), app, "private");
        trelloService.boardShow(board1.getId(), app);

        trelloService.addUserToBoard(board1.getId(), user1, app);
        trelloService.addUserToBoard(board1.getId(), user2, app);
        trelloService.addUserToBoard(board1.getId(), user3, app);

        trelloService.boardShow(board1.getId(), app);
        trelloService.removeUserToBoard(board1.getId(), user2, app);
        trelloService.boardShow(board1.getId(), app);

        trelloService.show(app);
        trelloService.deleteBoard(board2.getId(), app);
        trelloService.show(app);

        Project project1 = new Project("Mock Interviews");
        trelloService.addProjectToBoard(board1.getId(), project1, app);
        trelloService.projectShow(project1.getId(), app);
        trelloService.updateProjectName(project1.getId(), "Mock Interviews - Applied", app);

        Project project2 = new Project("Mock Interviews - Scheduled");
        trelloService.addProjectToBoard(board1.getId(), project2, app);
        trelloService.boardShow(board1.getId(), app);

        Card card1 = new Card("abcd@gmail.com");
        Card card2 = new Card("abcda@gmail.com");

        trelloService.addCardToProject(project1.getId(), card1, app);
        trelloService.addCardToProject(project1.getId(), card2, app);

        trelloService.projectShow(project1.getId(), app);
        trelloService.updateCardDescription(card1.getId(), "At 7PM", app);
        trelloService.projectShow(project1.getId(), app);

        trelloService.cardAssign(card1.getId(), user1.getUserId(), app);
        trelloService.cardShow(card2.getId(), app);
        trelloService.cardMove(card1.getId(), user2.getUserId(), app);
        trelloService.projectShow(project1.getId(), app);
        trelloService.projectShow(project2.getId(), app);

        trelloService.cardShow(card1.getId(), app);
        trelloService.cardUnAssign(card1.getId(), app);
        trelloService.cardShow(card1.getId(), app);
    }
}
