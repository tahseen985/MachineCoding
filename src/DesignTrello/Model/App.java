package DesignTrello.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    String appName;
    List<Board> boardList;

    public App(String appName) {
        this.appName = appName;
        this.boardList = new ArrayList<>();
        System.out.println("App created with name : " + appName);
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public List<Board> getBoardList() {
        return boardList;
    }

    public void setBoardList(List<Board> boardList) {
        this.boardList = boardList;
    }

    public void addBoard(Board board) {
        this.boardList.add(board);
    }

    @Override
    public String toString() {
        return "App{" +
                "appName='" + appName + '\'' +
                ", boardList=" + boardList +
                '}';
    }
}
