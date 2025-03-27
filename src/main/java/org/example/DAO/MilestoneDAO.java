package org.example.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.entities.*;

public class MilestoneDAO {
    private final Connection connection;

    public MilestoneDAO(Connection connection) {
        this.connection = connection;
    }

    public void addMilestone(Milestone milestone) throws SQLException {
        String sql = "INSERT INTO milestones (project_id, title, description, due_date, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, milestone.getProjectId());
            stmt.setString(2, milestone.getTitle());
            stmt.setString(3, milestone.getDescription());
            stmt.setDate(4, new java.sql.Date(milestone.getDueDate().getTime()));
            stmt.setString(5, milestone.getStatus());
            stmt.executeUpdate();
        }
    }
}
