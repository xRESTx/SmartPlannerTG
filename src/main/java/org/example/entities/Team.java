package org.example.entities;

public class Team {
    private int id;
    private int projectId;
    private int userId;
    private String role;

    public Team(int id, int projectId, int userId, String role) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
// Геттеры и сеттеры
}
