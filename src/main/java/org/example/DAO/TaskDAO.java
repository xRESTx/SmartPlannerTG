package org.example.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.entities.Task;

public class TaskDAO {
    private final Connection connection;

    public TaskDAO(Connection connection) {
        this.connection = connection;
    }

    public void addTask(Task task) throws SQLException {
        String sql = "INSERT INTO tasks (title, description, status, priority, due_date, project_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDescription());
            stmt.setString(3, task.getStatus());
            stmt.setString(4, task.getPriority());
            stmt.setDate(5, task.getDueDate() != null ? new java.sql.Date(task.getDueDate().getTime()) : null);
            stmt.setInt(6, task.getProjectId());
            stmt.executeUpdate();
        }
    }

    public List<Task> getAllTasksByProject(int projectId) throws SQLException {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks WHERE project_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, projectId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tasks.add(new Task(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("status"),
                        rs.getString("priority"),
                        rs.getDate("due_date"),
                        rs.getInt("project_id")
                ));
            }
        }
        return tasks;
    }
}
