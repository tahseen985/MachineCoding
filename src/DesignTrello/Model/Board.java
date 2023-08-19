package DesignTrello.Model;

import DesignTrello.Enum.Privacy;

import java.util.ArrayList;
import java.util.List;

public class Board {
    String id;
    String name;
    Privacy privacy;
    String url;
    List<User> memberList;
    List<Project> projectList;
    private static int boardIdCounter = 1;

    public Board(String name) {
        this.name = name;
        this.id = name + '0' + boardIdCounter;
        boardIdCounter++;
        this.privacy = Privacy.PUBLIC;
        this.memberList = new ArrayList<>();
        this.projectList = new ArrayList<>();
        System.out.println("Board created with name : " + name);
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

    public Privacy getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Privacy privacy) {
        this.privacy = privacy;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<User> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<User> memberList) {
        this.memberList = memberList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public void addProject(Project project) {
        this.projectList.add(project);
    }

    public void addUser(User user) {
        this.memberList.add(user);
    }

    @Override
    public String toString() {
        return "Board{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", privacy=" + privacy +
                ", url='" + url + '\'' +
                ", memberList=" + memberList +
                ", projectList=" + projectList +
                '}';
    }
}
