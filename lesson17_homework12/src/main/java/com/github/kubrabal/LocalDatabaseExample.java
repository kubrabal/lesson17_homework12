package com.github.kubrabal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class LocalDatabaseExample {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/local_db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {

            String createTableSQL = "CREATE TABLE IF NOT EXISTS ad_soyad (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255))";
            try (PreparedStatement pstmt = conn.prepareStatement(createTableSQL)) {
                pstmt.executeUpdate();
            }

            String insertSQL = "INSERT INTO ad_soyad (name) VALUES (?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                pstmt.setString(1, "Ali");
                pstmt.executeUpdate();
                pstmt.setString(1, "Veli");
                pstmt.executeUpdate();
                pstmt.setString(1, "Ahmet");
                pstmt.executeUpdate();
            }

            String deleteSQL = "DELETE FROM ad_soyad WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
                pstmt.setInt(1, 1);
                pstmt.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
