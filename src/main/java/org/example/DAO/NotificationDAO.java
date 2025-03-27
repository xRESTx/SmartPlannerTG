package org.example.DAO;

import java.sql.*;
import org.example.entities.*;

public class NotificationDAO {
    private final Connection connection;

    public NotificationDAO(Connection connection) {
        this.connection = connection;
    }

    public void addNotification(Notification notification) throws SQLException {
        String sql = "INSERT INTO notifications (user_id, message, is_read, created_at) VALUES (?, ?, false, NOW())";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, notification.getUserId());
            stmt.setString(2, notification.getMessage());
            stmt.executeUpdate();
        }
    }
}
