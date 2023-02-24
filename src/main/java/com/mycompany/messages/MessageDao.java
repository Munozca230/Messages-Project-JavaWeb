package com.mycompany.messages;

import static com.mycompany.messages.ConnectionSql.*;
import java.sql.*;
import java.util.*;

public class MessageDao {

    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Message message;

    public List<Message> select() throws ClassNotFoundException {
        String sql = "SELECT * FROM messages";
        List<Message> messages = new ArrayList<>();

        try {
            this.cn = getConnection();
            this.ps = this.cn.prepareStatement(sql);
            this.rs = this.ps.executeQuery();

            while (this.rs.next()) {
                int id = this.rs.getInt("id_message");
                String msg = this.rs.getString("message");
                String nickname = this.rs.getString("nickname");
                String date = this.rs.getString("date");

                this.message = new Message(id, msg, nickname, date);
                messages.add(this.message);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(this.rs);
                close(this.ps);
                close(this.cn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return messages;
    }

    public int insert(Message message) throws ClassNotFoundException {
        String sql = "INSERT INTO messages (message,nickname,date) VALUES (?,?,CURRENT_TIME())";
        int entrys = 0;
        try {
            this.cn = getConnection();
            this.ps = this.cn.prepareStatement(sql);

            this.ps.setString(1, message.getMessage());
            this.ps.setString(2, message.getNickname());
            entrys = this.ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(this.ps);
                close(this.cn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return entrys;

    }

    public int update(Message message) throws ClassNotFoundException {
        String sql = "UPDATE messages SET message=?,nickname=? WHERE id_message=?";
        int entrys = 0;
        try {
            this.cn = getConnection();
            this.ps = this.cn.prepareStatement(sql);

            this.ps.setString(1, message.getMessage());
            this.ps.setString(2, message.getNickname());
            this.ps.setInt(3, message.getId());
            entrys = this.ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(this.ps);
                close(this.cn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return entrys;
    }
    
    public int delete(Message message) throws ClassNotFoundException {
        String sql = "DELETE FROM messages WHERE id_message=?";
        int entrys = 0;
        try {
            this.cn = getConnection();
            this.ps = this.cn.prepareStatement(sql);

            this.ps.setInt(1, message.getId());
            entrys = this.ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(this.ps);
                close(this.cn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return entrys;
    }
}
