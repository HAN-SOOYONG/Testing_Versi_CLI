package com.keep;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteDAO {
 public void addNote(Note note) {
        String sql = "INSERT INTO notes(title, content) VALUES(?, ?)";

        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, note.getTitle());
            pstmt.setString(2, note.getContent());

            pstmt.executeUpdate();

                } catch (SQLException e) {
            System.out.println("[ERROR] Gagal menambah catatan: " + e.getMessage());
        }
    }

    public List<Note> getAllNotes() {
        List<Note> list = new ArrayList<>();
        String sql = "SELECT * FROM notes";
        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                Note note = new Note(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("content")
                );
                
                list.add(note);
            }
            } catch (SQLException e) {
            System.out.println(" [ERROR] Gagal mengambil catatan: " + e.getMessage());
        }
        return list;
    }
}
                