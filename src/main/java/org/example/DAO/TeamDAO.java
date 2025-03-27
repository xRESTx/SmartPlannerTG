package org.example.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.entities.*;

public class TeamDAO {
    private final Connection connection;

    public TeamDAO(Connection connection) {
        this.connection = connection;
    }

    public void addTeamMember(Team team) throws SQLException {
        String sql = "INSERT INTO teams (project_id, user_id, role) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, team.getProjectId());
            stmt.setInt(2, team.getUserId());
            stmt.setString(3, team.getRole());
            stmt.executeUpdate();
        }
    }

    public List<Team> getTeamByProject(int projectId) throws SQLException {
        List<Team> teamList = new ArrayList<>();
        String sql = "SELECT * FROM teams WHERE project_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, projectId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                teamList.add(new Team(
                        rs.getInt("id"),
                        rs.getInt("project_id"),
                        rs.getInt("user_id"),
                        rs.getString("role")
                ));
            }
        }
        return teamList;
    }
}
