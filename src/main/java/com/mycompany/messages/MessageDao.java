package com.mycompany.messages;

import static com.mycompany.messages.ConnectionSql.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
}
