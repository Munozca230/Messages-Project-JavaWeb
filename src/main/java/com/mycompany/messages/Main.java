
package com.mycompany.messages;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //ConnectionSql.getConnection();
        //System.out.println("Succesful connection");
        
        MessageDao messageDao = new MessageDao();
        List<Message> messages = messageDao.select();
        
        for (Message message : messages) {
            System.out.println(message);
        }
    }
}
