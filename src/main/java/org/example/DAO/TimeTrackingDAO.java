package org.example.DAO;

import java.sql.*;
import org.example.entities.*;

public class TimeTrackingDAO {
    private final Connection connection;

    public TimeTrackingDAO(Connection connection) {
        this.connection = connection;
    }

    public void startTracking(int userId, int taskId) throws SQLException {
        String sql = "INSERT INTO time_tracking (user_id, task_id, start_time) VALUES (?, ?, NOW())";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, taskId);
            stmt.executeUpdate();
        }
    }

    public void stopTracking(int id) throws SQLException {
        String sql = "UPDATE time_tracking SET end_time = NOW() WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
